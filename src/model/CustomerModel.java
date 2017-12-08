package model;

import data.account.AccountType;
import data.customer.Customer;
import data.customer.CustomerType;
import data.customer.RegularCustomer;
import data.customer.StudentCustomer;
import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerModel {

    // Get A Customer with their email
    public static Customer getCustomer(String email) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM users WHERE email=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, email);

        ResultSet set = statement.executeQuery();

        return generateCustomer(set);
    }

    // Get A List of Customer from Database

    public static List<Customer> getCustomers() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM users";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();

        LinkedList<Customer> customers = new LinkedList<>();


        while (set.next()) {
            customers.push(generateCustomer(set));
        }

        return customers;
    }

    private static Customer generateCustomer(ResultSet set) throws Exception {
        String type = set.getString("type");
        int id = Integer.parseInt(set.getString("id"));
        int accountId = Integer.parseInt(set.getString("accountId"));
        String name = set.getString("name");
        String emails = set.getString("email");
        String password = set.getString("password");
        long bdate = Long.parseLong(set.getString("birthday"));

        if (type.equals(CustomerType.STUDENT.name())) {
            return new StudentCustomer(name, id, emails, password, accountId, bdate, CustomerType.STUDENT);
        } else if (type.equals(CustomerType.REGULAR.name())) {
            return new RegularCustomer(name, id, emails, password, accountId, bdate, CustomerType.REGULAR);
        }else {
            throw new Exception("Didn't Match Type");
        }
    }

    public static void createCustomer(Customer customer) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "INSERT INTO users (name, email, password, birthday, type, accountid) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getEmail());
        statement.setString(3, customer.getPassword());
        statement.setString(4, String.valueOf(customer.getBirthDate()));
        statement.setString(5, customer.getCustomerType().name());
        statement.setString(6, String.valueOf(customer.getAccountId()));

        statement.execute();
        System.out.println("Customer Created Successfully");

    }
}
