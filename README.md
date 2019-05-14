# jvs-mairistem-cli-java

Client Jvs-Mairistem (Java 8)

Client pour les API Jvs-Mairstem pour les partenaires.

Le but de ce projet est d'abstraire la partie technique d'échange de données avec les applications Jvs-Mairistem, en commençant par Omega. Ce projet évoluera avec les modifications d'Omega, il faut donc garder une cohérence entre la version d'Omega et celle du client utilisé, cohérene assurée et vérifié par le client.

**Pour le détail des versions, se référer au fichier [CHANGELOG](./CHANGELOG).**

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
    // Pour le tty si on n'indique pas la passphrase
    export GPG_TTY=$(tty)
    // Package
    mvn package
    // Déploiement local
    mvn install:install-file -Dfile=JvsMairistemCli-1.0.3.jar -DpomFile=pom.xml
    // Compile
    mvn clean compile exec:java -Dexec.mainClass="fr.jvsonline.jvsmairistemcli.App"
```

## Structure / utilisation

Ce projet contient différentes parties :

```
   jvsmairistemcli
     |---- core                // Pour les classes techniques (config, ws, ...)
     |---- jackson             // Surcharge de la partie jackson des services web
     |---- model               // Modèles communs, lorsque c'est possible (personne, adresse, ...)
     |---- omega               // Partie spécifique Omega
          |---- manager        // Les managers d'accès aux services web
          |---- model          // Les modèles Omega
```

En fonction de l'application utilisée, un ensemble de modèles et services vont être mis à disposition. Ces classes serviront pour les échanges et le contrôle des données. Chaque application mettra également à disposition une documentation complète.

Vous trouverez [ici](https://github.com/jvs-groupe/omega-api-doc) la documentation de l'API.

## Utiliser le client jvsmairistemcli

### Intégration basique

```
  /**
   * Initialisation via des "constantes", il est possible d'utiliser un fichier de "properties"
   * omegaSettings est un Singleton
   *
   * @return void
   */
  protected void initJvsMairistemCli() {
    logger.info("----------------------------------------------------------");
    logger.info("JVS-Mairistem Client settings...");
    Settings omegaSettings = Settings.getInstance();
    omegaSettings.setWsEndpoint("https://omegaweb-pp.jvsonline.fr/api/v1");
    omegaSettings.setWsApiId("dfc7258e09f94ba6e495a08c50d6fd00@partner-kis-jolieville");
    omegaSettings.setWsHawkId("partner-kis-jolieville");
    omegaSettings.setWsHawkKey("be58e42b95c303f3a64faf5c70f7d7e7");
    logger.info("   Version  : " + omegaSettings.getVersion());
    logger.info("   Endpoint : " + omegaSettings.getWsEndpoint());
    this.wsClient = new JsonApiWS(omegaSettings);
    this.omegaContainer = new Container();
    logger.info("   Récupération des codifications...");
    EnumerationManager enumManager = null;
    enumManager = new EnumerationManager(wsClient);
    List<EnumerationModel> myListE = enumManager.find();
    if (myListE == null) {
      logger.info("Empty result...");
    } else {
      for (EnumerationModel item : myListE) {
        logger.info("Enumération " + item.getNom());
      }
    }
    omegaContainer.setEnums(myListE);
    logger.info("----------------------------------------------------------");
  }
```

### Projet exemple

    * Exemple via le projet https://github.com/jvs-groupe/jvs-mairistem-webapp


### Deploiement

``` 
    export GPG_TTY=$(tty)
    mvn clean deploy
```

Le mot de passe D..P......!D..F...2019
