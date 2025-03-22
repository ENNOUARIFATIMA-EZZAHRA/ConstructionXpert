package Model;

import java.sql.Date;

public class TacheModel {
    private int id;
    private int projetId;
    private String description;
    private Date dateDebut;
    private Date dateFin;


    public TacheModel(int projetId, String description, Date dateDebut, Date dateFin) {
        this.projetId = projetId;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public TacheModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    public Date getDate_fin() {
        return dateFin;
    }

    public void setDate_fin(Date date_Fin) {
        this.dateFin = date_Fin;
    }

    public Date getDate_debut() {
        return dateDebut;
    }

    public void setDate_debut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}