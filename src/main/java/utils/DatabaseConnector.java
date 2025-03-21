package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/constructionxpert";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            // Charger le driver JDBC (optionnel à partir de JDBC 4.0)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retourner une connexion
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de connexion à la base de données !");
        }
    }
}
