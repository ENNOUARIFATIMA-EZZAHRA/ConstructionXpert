create database ConstructionXpert;
use ConstructionXpert;
CREATE TABLE projets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    date_debut DATE,
    date_fin DATE,
    budget DECIMAL(15,2)
   
);

CREATE TABLE taches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    projet_id INT NOT NULL,
    description TEXT NOT NULL,
    date_debut DATE,
    date_fin DATE,
    FOREIGN KEY (projet_id) REFERENCES projets(id) ON DELETE CASCADE
);

CREATE TABLE ressources (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    quantite INT DEFAULT 0,
    fournisseur VARCHAR(255)
   
);