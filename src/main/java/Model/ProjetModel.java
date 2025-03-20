package Model;

import java.sql.Date;

public class ProjetModel {
    private int id;
    private static String nom;
    private static String description;
    private static Date date_debut;
    private static Date date_fin;
    private static float budget;


    public ProjetModel(int id, String nom, String description, Date date_debut, Date date_fin, float budget) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.budget = budget;
    }

    public ProjetModel(String nom, String description, Date date_debut, Date date_fin, float budget) {

        this.nom = nom;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.budget = budget;
    }

    public ProjetModel(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public ProjetModel(){}

    public ProjetModel(int id, String nom, String description, Date date_debut, Date date_fin, Double budget) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public static Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public static float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }


    public void updateProjet(ProjetModel projet) {
    }
}
