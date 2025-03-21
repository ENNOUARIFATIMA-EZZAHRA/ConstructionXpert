# 🏗️ ConstructionXpert Services - Application de Gestion de Projets de Construction

## 📌 Description de l'application

**ConstructionXpert Services** est une application web de gestion de projets de construction développée en Java EE. Elle permet à un administrateur de planifier, organiser et suivre des projets de construction en gérant les projets, les tâches, les ressources et les fournisseurs. L'application offre une interface simple, responsive et intuitive permettant une gestion centralisée et efficace.

---

## 🎯 Fonctionnalités principales

### 🔐 Authentification
- Connexion et déconnexion de l'administrateur.
- Protection des pages : accès restreint aux utilisateurs non authentifiés.

### 🗂️ Gestion des Projets
- Créer un projet avec : nom, description, date de début, date de fin, budget.
- Afficher la liste des projets.
- Modifier les informations d’un projet.
- Supprimer un projet.

### ✅ Gestion des Tâches
- Créer une tâche liée à un projet avec : description, date de début, date de fin, ressources nécessaires.
- Afficher les tâches d’un projet.
- Modifier une tâche.
- Supprimer une tâche.

### 🧰 Gestion des Ressources
- Ajouter des ressources avec : nom, type, quantité, fournisseur.
- Afficher la liste des ressources disponibles.
- Modifier les informations d’une ressource.
- Supprimer une ressource.
- Mettre à jour la quantité après assignation à une tâche.

### 🧾 Gestion des Fournisseurs (Bonus)
- Ajouter, afficher, modifier et supprimer des fournisseurs.

---

## 🛠️ Technologies utilisées

| Composant          | Technologie             |
|--------------------|--------------------------|
| Langage            | Java                     |
| Framework Web      | Java EE (Servlets, JSP)  |
| Architecture       | MVC + DAO                |
| Base de Données    | MySQL / PostgreSQL       |
| Communication DB   | JDBC                     |
| Serveur            | Apache Tomcat 9          |
| Frontend           | HTML, CSS (Bootstrap / Tailwind), JavaScript |
| Maquettage         | Figma / Adobe XD         |
| Versioning         | Git / GitHub             |

---

## 📈 UML Diagrammes

- ✅ Diagramme de Cas d’Utilisation (format image)
- ✅ Diagramme de Classes (format image)
- ✅ Diagramme de Séquence (format image)

Les images se trouvent dans le dossier `/uml-diagrams`.

---

## 🔗 Liens utiles

- 📊 [Lien vers la planification (Trello)](https://...)
- 🖌️ [Lien vers la maquette Figma](https://...)
- 📁 [Lien vers le repository GitHub](https://github.com/...)

---

## 🚀 Lancement du projet

1. Cloner le projet :
```bash
git clone https://github.com/ton-utilisateur/ConstructionXpert.git
2-Importer dans Eclipse / IntelliJ comme projet Maven.

3-Configurer la base de données MySQL / PostgreSQL (script disponible dans /database).

4-Déployer le projet sur Apache Tomcat 9.

5-Accéder à l'application via :
http://localhost:8080/ConstructionXpert/
📂 Structure du projet
ConstructionXpert/
├── src/
│   ├── controller/        # Servlets
│   ├── dao/               # Accès aux données
│   ├── model/             # Modèles Java
│   └── util/              # Connexion DB
├── webapp/
│   ├── WEB-INF/
│   ├── views/             # JSPs
│   └── assets/            # CSS, JS
├── database/              # Script SQL
├── uml-diagrams/          # Diagrammes UML
├── README.md
└── pom.xml
📅 Détails
Date de lancement : 17/03/2025 à 09:00
Date limite de soumission : 21/03/2025 avant 16h00

✅ Critères respectés
Fonctionnalités complètes et fonctionnelles ✅
Interface responsive et conviviale ✅
Code bien structuré en MVC + DAO ✅
Documentation claire ✅
Respect des délais ✅

#LES DIAGRAMMES

<img width="683" alt="image" src="https://github.com/user-attachments/assets/03a21218-69d3-4f5f-9b17-3810ac1aed33" />




