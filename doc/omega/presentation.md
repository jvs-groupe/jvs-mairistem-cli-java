Client Omega
---

Nous utiliserons une API au format restful pour communiquer entre le client et le serveur. Un client jersey sera utilisé dans ce projet.

## Sécurité des échanges

Les échanges seront sécurisés suivant les spécifications [Hawk](https://github.com/hueniverse/hawk). Seul le protocole https sera supporté.

Pour chaque connexion vers un de nos clients nous fournirons :

* Une clef d'API à passer dans les en-têtes
* Un identifiant Hawk
* Une clef Hawk

**La clef Hawk ne devra pas être visible ou accessible car elle sert de clef de cryptage et de vérifications des échanges.**

## Format des échanges : Json-Api

Ce format correspond aux spécifications décrites [ici](https://jsonapi.org/format/1.0/)

## Utilisation des classes

### Principe

Les services web permettent de mettre à disposition des données métiers telles que le contrats, compteurs, points de consommation, ... mais également des données tecnniques comme par exemple les diamètres de compteurs, civilités, ... (énumérations, codifications)

Le détail se trouve dans la documentation [omega-api-doc](https://github.com/jvs-groupe/omega-api-doc)

### Le client WS

Il faut déjà instancier un client JsonApi pour les appels. Pour celà il a besoin d'une configuration contenant les différents paramètres de connexion aux services web :

* Endpoint : url d'appel du service web
* ApiId    : identifiant de l'application pour le client ciblé
* HawkId   : Identifiant HAWK
* HawkKey  : Clef de sécurité des échanges

```
  try {
    // Déjà le paramétrage, ici via un fichier de propriétés.
    // Il existe aussi des "setters" si besoin, getinstance sans paramètre
    Settings omegaSettings = Settings.getInstance("jvsmairistemcli.properties");
    // Instance du client en passant les paramètres
    JsonApiWS wsClient = new JsonApiWS(omegaSettings);
  } catch (Exception ex) {
    // @todo : send to logger
  }
```

### Appeler un service web

Comme exemple nous allons utiliser les énumérations. Pour récupérer la liste des énumérations nous allons instancier le manager correspondant.

```
  // On passe en paramètre le client créé précédemment.
  EnumerationManager enumManager = new EnumerationManager(wsClient);
```

Ici le service web nous retourne par défaut toutes les énumérations. De plus pour chaque manager on dispose au moins d'un modèle correspondant, l'appel est donc simple :

```
  // On stocke la liste et on parcours les éléments retournés.
  List<EnumerationModel> myListE = enumManager.find();
  if (myListE == null) {
    logger.info("Empty result...");
  } else {
    for (EnumerationModel item : myListE) {
      logger.info("Enumération " + item.getNom());
    }
  }
```

Les modèles disposent de getter et setter pour accéder aux propriétés. Les propriétés sont "mappées" aux champs du service web afin de rendre les champs plus parlant et maintenir une cohérence dans le temps. Les propriétés peuvent également être d'autres modèles, comme par exemple le compteur d'un point de consommation. C'est le paramétrage du service web qui permet de récupérer plus au moins de données en un seul appel, en fonction des besoins d'utilisation. Nous utilisons ici les valeurs par défaut que l'on retrouve dans la document technique du service web [omega-api-doc](https://github.com/jvs-groupe/omega-api-doc)

_Il faut noter qu'un modèle aura toujours la même structure. Un compteur sur un point de consommation sera le même type d'objet qu'un compteur accédé directement. De même un occupant et un redevable seront un modèle personne._

### Le conteneur Omega

Le client met également à disposition un conteneur pour stocker des données techniques qui peuvent être utilisées à divers endroits. Ce conteneur dispose également de méthodes permettant de simplifier la logique d'utilisation de ces données techniques. Il sert principalement à la gestion des énumérations, codifications, ...
Son but est aussi de mettre les données en cache au besoin.

```
  // Instance du conteneur
  Container omegaContainer = new Container();
```

#### Les énumérations

Les [énumérations](https://github.com/jvs-groupe/omega-api-doc#les-%C3%A9num%C3%A9rations) permettent de gérer toutes sortes de codifications, le mieux étant de les sauvegarder dans le conteneur pour éviter des appels répétitifs.

```
  // Instance du manager qui permet d'appeler les WS de gestion des énumérations.
  EnumerationManager enumManager = new EnumerationManager(wsClient);
  // On demande la page 1 avec une limite de 999
  enumManager.setPage(1);
  enumManager.setPageLimit(999);
  // Recherche
  List<EnumerationModel> myListE = enumManager.find();
  omegaContainer.setEnums(myListE);
  // On recupère une ligne spécifique d'une énumération, listées dans l'enum EnumerationType
  LigneEnumerationModel diametre = omegaContainer.getLigneEnumeration(
    EnumerationType.DIAMETRE_COMPTEUR,
    item.getDiametre()
  );
```

#### Les articles

Les articles sont nécessaires pour une facturation. En effet ce sont les codes définis par le client et liés à la facturation. Ils disposent d'informations comme un libellé, un prix unitaire, une unité, ...

```
  // Instance du manager qui permet d'appeler les WS de gestion des articles. 
  ArticleManager artManager = new ArticleManager(wsClient);
  // On demande la page 1 avec une limite de 999
  artManager.setPage(1);
  artManager.setPageLimit(100);
  // On ne prend que les actifs, attention en cas de gestion d'affichage d'un historique
  artManager.addRequestParameter("actif", "1");
  // Recherche
  List<ArticleModel> myListArts = artManager.find();
  omegaContainer.setArticles(myListArts);
```

#### L'organisme factureur

L'organisme factureur est obligatoire pour préciser pour le compte de qui est émise la facture. Dans beaucoup de cas il n'y en a qu'un.

```
  // Instance du manager qui permet d'appeler les WS de gestion des organismes factureurs.
  OrganismeFactureurManager ofactManager = new OrganismeFactureurManager(wsClient);
  // Critères de recherche
  ofactManager.setPage(1);
  ofactManager.setPageLimit(10);
  // Recherche
  List<OrganismeFactureurModel> myListOfacts = ofactManager.find();
  for (OrganismeFactureurModel item : myListOfacts) {
    omegaContainer.setOrganismeFactureur(item);
    break;
  }
```

### Rechercher

Pour rechercher avec critères, les managers disposent de certaines méthodes.

#### Purger tous les critères

```
  monManager.flushRequestParameters();
```

#### Définir la page de départ, les limites

```
  // 25 éléments maximum, la première page
  monManager.setPage(1);
  monManager.setPageLimit(25);
```

Par défaut la limite de longueur est de 20.

#### Filtrer les résultats

Le critère passé est le nom du membre de la classe gérée par le manager. Les noms des managers et objets gérés sont suffixés soit de Model soit de Manager. Donc pour le manager PersonneManager on peut filtrer à partir de PersonneModel. 

A noter que l'on peut rechercher sur des relations définies dans le modèle. Il suffit de séparer les éléments par un ".", exemple pour le point de consommation : contratactif.numero

```
  // numero est un membre de la classe principale gérée par le manager
  monManager.addRequestParameter("numero", "56");
````

#### Le mode de recherche

```
  monManager.setDefaultOperator(RequestParameterOperator.EQUAL);
```

Par défaut l'opérateur de recherche est "LIKE"

#### Le condition de recherche

```
  monManager.setDefaultCondition(RequestParameterCondition.OR);
```

Par défaut la condition de recherche est "AND"

#### Exemples

```
  // Instance du manager des points de consommation pour la recherche
  PointDeConsommationManager pconsoManager = new PointDeConsommationManager(wsClient);
  // On initialise les param§tres
  pconsoManager.flushRequestParameters();
  // On demande la première page
  pconsoManager.setPage(1);
  // On demande les points de consommation ayant 56 dans le numéro (par défaut like)
  // On précise le nom de la propriété, qui sera "mappée" lors de l'appel
  pconsoManager.addRequestParameter("numero", "56");
  // On lance la recherche pour récupérer une liste de PointDeConsommationModel
  List<PointDeConsommationModel> myList = pconsoManager.find();
```
