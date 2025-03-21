package Dao;

import Model.ProjetModel;
import utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDao {

    // Suppression de la variable statique 'connection'
    // private static final Connection connection = getConnection();

    // Création d'un projet
    public static void createProjet(ProjetModel projet) throws SQLException {
        String sql = "INSERT INTO projets (nom, description, date_debut, date_fin, budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();  // Appel dynamique ici
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setDate(3, projet.getDate_debut());
            stmt.setDate(4, projet.getDate_fin());
            stmt.setDouble(5, projet.getBudget());
            stmt.executeUpdate();
        }
    }

    // Récupérer tous les projets
    public static List<ProjetModel> getAllProjets() {
        List<ProjetModel> projets = new ArrayList<>();
        String sql = "SELECT * FROM projets";

        try (Connection conn = DatabaseConnector.getConnection();  // Appel dynamique ici
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ProjetModel projet = new ProjetModel(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        rs.getFloat("budget")
                );
                projets.add(projet);
            }
            System.out.println("Liste des projets chargée depuis la base.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projets;
    }

    // Mise à jour d'un projet
    public static void updateProjet(ProjetModel projet) {
        String sql = "UPDATE projets SET nom = ?, description = ?, date_debut = ?, date_fin = ?, budget = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();  // Appel dynamique ici
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setDate(3, projet.getDate_debut());
            stmt.setDate(4, projet.getDate_fin());
            stmt.setFloat(5, projet.getBudget());
            stmt.setInt(6, projet.getId());

            stmt.executeUpdate();
            System.out.println("Projet mis à jour : " + projet.getNom());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Suppression d'un projet
    public static boolean deleteProjet(int id) throws SQLException {
        String DELETE_PROJET_SQL = "DELETE FROM projets WHERE id = ?";
        boolean rowDeleted;
        try (Connection connection = DatabaseConnector.getConnection();  // Appel dynamique ici
             PreparedStatement statement = connection.prepareStatement(DELETE_PROJET_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Récupérer un projet par son ID
    public ProjetModel getProjetById(int id) {
        ProjetModel projet = null;
        String sql = "SELECT * FROM projets WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();  // Appel dynamique ici
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                projet = new ProjetModel();
                projet.setId(rs.getInt("id"));
                projet.setNom(rs.getString("nom"));
                projet.setDescription(rs.getString("description"));
                projet.setDate_debut(rs.getDate("date_debut"));
                projet.setDate_fin(rs.getDate("date_fin"));
                projet.setBudget(rs.getFloat("budget"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projet;
    }
}
