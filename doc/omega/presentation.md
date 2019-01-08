# Client Omega
---

Nous utiliserons une API au format restful pour communiquer enre le client et le serveur. Un client jersey sera utilisé dans ce projet.

## Sécurité des échanges

Les échanges seront sécurisés suivant les spécifications [Hawk](https://github.com/hueniverse/hawk). Seul le protocole https sera supporté.

Pour chaque connexion vers un de nos clients nous fournirons :

* Une clef d'API à passer dans les en-têtes
* Un identifiant Hawk
* Une clef Hawk

** La clef Hawk ne devra pas être visible ou accessible car elle sert de clef de cryptage et de vérifications des échanges. **

## Format des échanges : Json-Api

Ce format correspond aux spécifications décrites [ici](https://jsonapi.org/format/1.0/)
