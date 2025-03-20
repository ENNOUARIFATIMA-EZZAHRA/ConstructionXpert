package Dao;

import Model.ProjetModel;
import utils.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DatabaseConnector.getConnection;

public class ProjetDao {
    private static final Connection connection= getConnection();

public static void createProjet(ProjetModel projet) throws SQLException {
        String sql = "INSERT INTO projets (nom, description,date_debut,date_fin,budget) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setDate(3, projet.getDate_debut());
            stmt.setDate(4, projet.getDate_fin());
            stmt.setDouble(5, projet.getBudget());
            stmt.executeUpdate();
        }
}

//affichage

    public static List<ProjetModel> getAllProjets() {
        List<ProjetModel> projet = new ArrayList<>();
        String SELECT_ALL_LIST="select * from projets";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIST)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                Date date_debut = rs.getDate("Date_debut");
                Date date_fin = rs.getDate("Date_fin");
                Double budget = rs.getDouble("budget");
                projet.add(new ProjetModel(id, nom,description,date_debut,date_fin,budget));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"errour");
        }
        System.out.print("list of in method ");
        return projet;
    }

    public static boolean updateProjet(ProjetModel projet) throws SQLException {
        String UPDATE_PROJET_SQL = "UPDATE projet SET nom = ?, description = ?, date_debut = ?, date_fin = ?, budget = ? WHERE id = ?";
        boolean rowUpdated = false;

        DatabaseMetaData DatabaseConnection;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(UPDATE_PROJET_SQL)) {

            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setDate(3, projet.getDate_debut());
            stmt.setDate(4, projet.getDate_fin());
            stmt.setDouble(5, projet.getBudget());
            stmt.setInt(6, projet.getId()); // L'ID est nécessaire pour identifier le projet

            int affectedRows = stmt.executeUpdate();
            rowUpdated = (affectedRows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    }

