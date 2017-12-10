package model;

import data.Admin;
import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {

    public static Admin getAdmin(String email) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM admin WHERE email=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);

        ResultSet set = statement.executeQuery();

        if (set.next()) {
            return generateAdmin(set);
        }
        return null;
    }

    private static Admin generateAdmin(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        String email = set.getString("email");
        String password = set.getString("password");

        return new Admin(id, name, email, password);
    }

    public static void createAdmin(Admin admin) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, admin.getName());
        statement.setString(2, admin.getEmail());
        statement.setString(3, admin.getPassword());

        statement.executeUpdate();
        System.out.println("Admin Created Successfully...");
    }
}
