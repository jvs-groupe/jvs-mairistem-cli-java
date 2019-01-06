# jvs-mairistem-cli-java

Client Jvs-Mairistem (Java 8)

Client pour les API Omega spécifique pour les partenaires. Le but de ce projet est d'abstraire la partie technique d'échange de données avec les applications Jvs-Mairistem, en commençant par Omega. Ce projet évoluera avec les modifications d'Omega, il faut donc garder une cohérence entre la version d'Omega et celle du client utilisé, cohérene assurée et vérifié par le client.

** Pour le détail des versions, se référer au fichier CHANGELOG. **

## Installation

### Dépendances

* jersey
* jsonapi
* slf4j

### Développement

Ce projet est basé sur le conteneur u16_tomcat. Des connaissances de docker sont requises pour utiliser ces foncions. Les appels sont effectués vers une base de données de démonstration anonymisée. Pour accéder à une base test d'un de nos clients merci d'en faire la demande à nos services.

### Commandes

Depuis le conteneur dans le homedir du projet, à l'emplacement du fichier pom.xml

```
    // Se placer dans le bon répertoire
    cd /opt/java/jvs-mairistem-cli-java
    // Package
    mvn package
    // Compile
    mvn clean compile exec:java -Dexec.mainClass="fr.jvsonline.jvsmairistemcli.App"
```

## Client Omega

Nous utiliserons une API au format restful pour communiquer enre le client et le serveur. Un client jersey sera utilisé dans ce projet.

### Sécurité des échanges

Les échanges seront sécurisés suivant les spécifications [Hawk](https://github.com/hueniverse/hawk). Seul le protocole https sera supporté.

Pour chaque connexion vers un de nos clients nous fournirons :

* Une clef d'API à passer dans les en-têtes
* Un identifiant Hawk
* Une clef Hawk

** La clef Hawk ne devra pas être visible ou accessible car elle sert de clef de cryptage et de vérifications des échanges. **

### Format des échanges : Json-Api

Ce format correspond aux spécifications décrites [ici](https://jsonapi.org/format/1.0/)

#### Pagination

Pour des résultats retournant plusieurs éléments, il y a une pagination, par 20.

Le paramètre utilisé est page, exemples :

* page=2, la page 2, de 21 à 40
* page[offset]=21&page[limit]=20

#### filter: Filtres, critères de recherche

Pour la partie filter, voici le descriptif et quelques exemples :

* Egalité 'eq'
* Egalité ou null 'eqn'
* Différent 'neq'
* Différent ou null 'neqn'
* Supérieur 'gt'
* Supérieur ou null 'gtn'
* Supérieur ou égal 'gte'
* Supérieur ou égal ou null 'gten'
* Inférieur 'lt'
* Inférieur ou null 'ltn'
* Inférieur ou égal 'lte';
* Inférieur ou égal ou null 'lten';
* Contient 'like';
* Dans 'in';
* Pas dans 'nin';
* Vide 'empty';
* Pas vide 'nempty';
* Entre 'between';
* Commence par 'begin';
* Termine par 'end';

Exemple :

* filter[numpconso][eq]=abcdef&filter[pconso_id][gte]=23
* filter[voie][like]=principale&filter[ville][begin]=met

#### filter: Options

Pour l'instant les options suivantes sont disponibles :

* Opérateur par défaut si omis : filter[options][mode]=eq
* Sensibilité à la casse : filter[options][case_sensitive]=false
* Opérateur entre clauses : filter[options][andor]=and
