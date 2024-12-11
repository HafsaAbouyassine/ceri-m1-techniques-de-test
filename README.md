# Projet Java - Pokedex API

## Informations Personnelles
- **Nom** : Abouyassine
- **Prénom** : Hafsa
- **Groupe** : M1 ILSEN Grp1 class

## Badges de Statut

- [![CircleCI](https://dl.circleci.com/status-badge/img/gh/HafsaAbouyassine/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/HafsaAbouyassine/ceri-m1-techniques-de-test/tree/master)
- [![codecov](https://codecov.io/gh/HafsaAbouyassine/ceri-m1-techniques-de-test/graph/badge.svg?token=MFSONCTGBM)](https://codecov.io/gh/HafsaAbouyassine/ceri-m1-techniques-de-test)
- ![Checkstyle Badge](https://github.com/HafsaAbouyassine/ceri-m1-techniques-de-test/raw/master/badges/checkstyle-result.svg)

## Lien Javadoc 
- [Consulter la Javadoc](https://hafsaabouyassine.github.io/ceri-m1-techniques-de-test/)

## Description du Projet
Ce projet consiste en la création d'une API Pokedex en Java, permettant de manipuler des données de Pokémon telles que leurs caractéristiques et leur classement selon divers critères. L'objectif principal est de fournir une API robuste tout en intégrant des tests approfondis pour garantir la qualité du code.

## Dernières Mises à Jour

### Intégration de la RocketPokemonFactory
La `RocketPokemonFactory` ajoute une touche unique au projet en s'inspirant des manigances de la Team Rocket. Elle introduit des comportements atypiques et des Pokémon spéciaux tels que :
- **"Ash's Pikachu"** avec des statistiques exceptionnellement élevées.
- **"MISSINGNO"**, un Pokémon mythique connu pour ses bugs dans les jeux originaux.
- Génération aléatoire des statistiques pour refléter la nature imprévisible de la Team Rocket.
- Gestion des indices inconnus ou négatifs pour produire des Pokémon uniques.

Ces ajouts nécessitent des tests spécifiques pour vérifier leur bon fonctionnement et s'assurer qu'ils n'introduisent pas de déséquilibres ou de comportements inattendus.

### Points Clés
- Implémentation de comportements spécifiques pour les indices négatifs ou inconnus.
- Calcul simplifié des IVs avec des valeurs arbitraires pour certains cas particuliers.
- Documentation des défis rencontrés lors de la gestion des comportements atypiques.

## Choix Techniques et Implémentation

### Langage et Frameworks
- **Langage** : Java
- **Framework de Test** : JUnit pour les tests unitaires et Mockito pour les mocks.
- **Couverture de Test** : JaCoCo pour générer des rapports et publication sur Codecov.
- **CI/CD** : CircleCI pour l'intégration continue et les tests automatisés.

### Structure du Projet
- `src/main/java` : contient le code source principal.
- `src/test/java` : contient les tests unitaires.
- `target/site/jacoco` : contient les rapports de couverture JaCoCo.

### Classes Implémentées
- **Pokedex** : Gestion de la liste des Pokémons et des métadonnées.
- **PokedexFactory** : Création d'instances de Pokedex.
- **PokemonFactory** : Génération de Pokémon en fonction des paramètres fournis.
- **RocketPokemonFactory** : Une version unique de `IPokemonFactory` avec des caractéristiques spécifiques.
- **PokemonTrainerFactory** : Création de dresseurs avec un Pokedex associé.
- **PokemonMetadataProvider** : Fourniture des métadonnées d'un Pokémon donné.

### Tests Ajoutés
Des tests supplémentaires ont été intégrés pour garantir une couverture optimale, notamment :
- Vérification des comportements spécifiques de la `RocketPokemonFactory`.
- Tests pour les cas limites, comme les indices négatifs ou les valeurs invalides.
- Validation des statistiques générées aléatoirement.
- Vérification des Pokémon spéciaux et des comportements associés.

## Lancer les Tests
- **Exécuter les tests** : `mvn clean verify`

## Générer le Rapport de Couverture JaCoCo
- **Commande** : `mvn jacoco:report`

## Liens Utiles
- [Documentation Jacoco](https://www.jacoco.org/jacoco/)
- [Documentation Codecov](https://docs.codecov.com/docs/quick-start)
- [Documentation CircleCI](https://circleci.com/docs/)
