# Projet Java - Pokedex API

## Informations Personnelles
- **Nom** : Abouyassine
- **Prénom** : Hafsa
- **Groupe** : M1 ILSEN Grp1 class

## Badges de Statut

- [![CircleCI](https://dl.circleci.com/status-badge/img/gh/HafsaAbouyassine/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/HafsaAbouyassine/ceri-m1-techniques-de-test/tree/master)
- [![codecov](https://codecov.io/gh/HafsaAbouyassine/ceri-m1-techniques-de-test/graph/badge.svg?token=MFSONCTGBM)](https://codecov.io/gh/HafsaAbouyassine/ceri-m1-techniques-de-test)
- ![Checkstyle Badge](badges/checkstyle-badge.svg)

## Description du Projet
Ce projet consiste en la création d'une API Pokedex en Java, permettant de manipuler des données de Pokémon telles que leurs caractéristiques et leur classement selon divers critères. L'objectif principal est d'implémenter une API qui fournit les informations nécessaires sur chaque Pokémon et de réaliser des tests pour assurer la qualité du code.

## Choix Techniques et Implémentation

### Langage et Frameworks
- **Langage** : Java
- **Framework de Test** : JUnit pour les tests unitaires et Mockito pour les mocks, permettant de tester des classes isolées sans dépendances externes.
- **Couverture de Test** : JaCoCo, pour générer des rapports de couverture de code et les publier sur Codecov pour un suivi en ligne.
- **CI/CD** : CircleCI, pour l'intégration continue et l'exécution automatisée des tests sur chaque commit.

### Structure du Projet
- `src/main/java` : contient le code source de l'application.
- `src/test/java` : contient les tests unitaires.
- `target/site/jacoco` : contient les rapports de couverture générés par JaCoCo. 

### Classes Créées
- Pokedex : Gère la liste des Pokémons et fournit des méthodes pour accéder aux métadonnées.
- PokedexFactory : Crée une instance de Pokedex.
- PokemonFactory : Crée un Pokémon en utilisant les paramètres fournis.
- PokemonTrainerFactory : Crée un dresseur de Pokémon avec un Pokedex associé.
- PokemonMetadataProvider : Fournit des métadonnées pour un Pokémon donné.
Avec ces classes implémentées, les tests devraient reconnaître les symboles nécessaires et pouvoir compiler et s'exécuter.

### Lancer les tests 
- ```mvn clean verify```

### Générer le rapport de couverture JaCoCo 
- ```mvn jacoco:report```

### Liens Utiles
- [Documentation Jacoco](https://www.jacoco.org/jacoco/)
- [Documentation Codecov](https://docs.codecov.com/docs/quick-start)
- [Documentation CircleCI](https://circleci.com/docs/)
