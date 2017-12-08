package db;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection;
    private static DatabaseConnection instance;

    // Private Constructor
    private DatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:bank_db.sqlite");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get Instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    // Return Connections
    public Connection getConnection() {
        return connection;
    }

    // Close Connections
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
