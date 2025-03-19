package Dao;

import Model.ProjetModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.DatabaseConnector.getConnection;
public class ProjetDao {
    private static Connection connection;

public static void createProjet(ProjetModel projet) throws SQLException {
        String sql = "INSERT INTO projet (nom, description,date_debut,date_debut,date_fin,budget)VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, projet.getId());
            stmt.setString(2, projet.getNom());
            stmt.setString(3, projet.getDescription());
            stmt.setDate(4, projet.getDate_debut());
            stmt.setDate(5, projet.getDate_fin());
            stmt.setDate(6, projet.getDate_fin());
            stmt.setDouble(7, projet.getBudget());
            stmt.executeUpdate();
        }
}


}
