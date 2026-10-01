# ⚔ Combat Arena — Julien, Leo & Challenger

Projet Java / Spring Boot réalisé dans le cadre du Bachelor Coding & Digital Innovation.
Le projet met en scène trois personnages — **Julien**, **Leo** et un **Challenger** créé par l'utilisateur — qui peuvent se battre entre eux (2 ou 3 à la fois), encaisser des dégâts calculés automatiquement selon leurs statistiques, et finissent toujours leur combat en réconciliation.

## 🧩 Ce que fait le projet

- Chaque personnage (Julien, Leo, Challenger) est un objet persistant en base de données, avec ses propres statistiques : taille, swag, action, points de vie (pv), et des attributs spécifiques (`beau` et `phrase` pour Leo, `nom` pour le Challenger).
- Une API REST (Spring Boot) permet de **créer**, **consulter**, **modifier** et **faire subir des dégâts** à chaque personnage.
- Les dégâts ne sont pas saisis à la main : ils sont **calculés automatiquement** à partir des statistiques du personnage (taille, swag, et bonus spécifiques).
- Un **scénario de combat** permet de faire s'affronter 2 ou 3 personnages (dans n'importe quelle combinaison : Julien vs Leo, Julien vs Challenger, Leo vs Challenger, ou les trois ensemble). Le combat se déroule sur plusieurs tours, chaque participant portant un coup aléatoire, et se termine toujours par une réconciliation.
- Une **interface web** (HTML/CSS/JS, en pixel art) permet de créer les personnages, voir et modifier leurs stats, lancer des combats, et garder un historique des personnages créés.
- Les données sont stockées dans une base **H2** en mode fichier, donc elles sont conservées même après avoir arrêté et relancé le serveur.

## 🗂 Structure du projet

```
src/main/java/com/example/demo/
├── DemoApplication.java         # Point d'entrée Spring Boot
├── personnages/                 # Interface Personnage + entités Julien, Leo, Challenger
├── repository/                  # Accès à la base de données (Spring Data JPA)
├── service/                     # Logique métier (création, dégâts, combat...)
└── controller/                  # Endpoints REST (API)

src/main/resources/
└── application.properties       # Configuration de la base H2

combat-interface-local.html      # Interface web (à ouvrir dans un navigateur)
style.css                        # Style pixel art de l'interface
```

## 🚀 Comment lancer le projet

### 1. Prérequis

- Java 17 (ou la version utilisée dans le projet) et Maven (généralement déjà gérés par IntelliJ)
- IntelliJ IDEA (ou un autre IDE Java)
- Un navigateur pour l'interface web

### 2. Lancer le serveur

1. Ouvrir le projet dans IntelliJ.
2. Laisser Maven télécharger les dépendances (`pom.xml`).
3. Lancer la classe `DemoApplication.java` (clic droit → Run).
4. Le serveur démarre sur `http://localhost:8081` (le port est défini dans `application.properties`).
5. Une base de données H2 est automatiquement créée dans le dossier `data/` au premier lancement, et conservée entre les redémarrages.

### 3. Tester l'API (avec Postman, par exemple)

Quelques exemples d'appels :

| Action                     | Méthode | URL                                                      |
|-----------------------------|---------|-----------------------------------------------------------|
| Créer Julien                | POST    | `http://localhost:8081/Julien?taille=180&swag=true&action=salut&pv=20` |
| Voir Julien (id=1)          | GET     | `http://localhost:8081/Julien?id=1`                       |
| Modifier Julien (id=1)      | PUT     | `http://localhost:8081/Julien?id=1&taille=180&swag=true&action=attaque&pv=15` |
| Appliquer des dégâts        | PUT     | `http://localhost:8081/Julien/degats?id=1`                 |
| Lancer un combat            | POST    | `http://localhost:8081/combat?participants=Julien:1,Leo:2` |

(Le même schéma s'applique à `/Leo` et `/Challenger`, avec leurs champs spécifiques.)

### 4. Utiliser l'interface web

1. Le serveur Spring Boot doit être lancé (étape 2).
2. Ouvrir le fichier `combat-interface-local.html` directement dans un navigateur (double-clic, ou "Ouvrir avec").
3. Vérifier que le champ "Serveur" en haut de la page correspond bien à l'adresse du serveur (`http://localhost:8081` par défaut).
4. Créer des personnages, consulter/modifier leurs stats, cocher 2 ou 3 participants et cliquer sur "Combattre !".

L'historique des personnages créés et les champs remplis sont conservés même après avoir rafraîchi la page (stockés localement dans le navigateur).

## 🛠 Technologies utilisées

- Java 17, Spring Boot (Web, Data JPA)
- Base de données H2 (mode fichier)
- HTML / CSS / JavaScript (vanilla, sans framework) pour l'interface