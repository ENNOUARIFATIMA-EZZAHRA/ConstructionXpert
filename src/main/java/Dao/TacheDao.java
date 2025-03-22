package Dao;

import Model.TacheModel;
import utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TacheDao {

    public static void createTache(TacheModel Tache) throws SQLException {
        String sql = "INSERT INTO projets (nom, description, date_debut, date_fin, budget) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Tache.getProjetId());
            stmt.setString(2, Tache.getDescription());
            stmt.setDate(3, Tache.getDate_debut());
            stmt.setDate(4, Tache.getDate_fin());

            stmt.executeUpdate();
        }
    }

    // Recuperer tous les Taches
    public static List<TacheModel> getAllTaches() {
        List<TacheModel> taches = new ArrayList<>();
        String sql = "SELECT * FROM Taches";

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TacheModel Tache = new TacheModel(
                        rs.getInt("ProjetId"),
                        rs.getString("description"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),

                );
                taches.add(Tache);
            }
            System.out.println("Liste des taches chargee depuis la base.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taches;
    }

    // Mise a jour d'un tache
    public static void updateTache(TacheModel Tache) {
        String sql = "UPDATE Taches SET nom = ?, description = ?, date_debut = ?, date_fin = ?, budget = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Tache.getProjetId());
            stmt.setString(2, Tache.getDescription());
            stmt.setDate(3, Tache.getDate_debut());
            stmt.setDate(4, Tache.getDate_fin());

            stmt.setInt(6, Tache.getId());

            stmt.executeUpdate();
            System.out.println("Tache mis à jour : " + Tache.getProjetId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Suppression d'un Tache
    public static boolean deleteTache(int id) throws SQLException {
        String DELETE_TACHE_SQL = "DELETE FROM taches WHERE id = ?";
        boolean rowDeleted;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TACHE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Récupérer un tache par son ID
    public TacheModel getTacheById(int id) {
        TacheModel tache= null;
        String sql = "SELECT * FROM taches WHERE id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tache = new TacheModel();
                tache.setId(rs.getInt("id"));
                tache.setProjetId(rs.getInt("ProjetId"));
                tache.setDescription(rs.getString("description"));
                tache.setDate_debut(rs.getDate("date_debut"));
                tache.setDate_fin(rs.getDate("date_fin"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tache;
    }
}
