package model;

import data.account.Account;
import data.account.AccountType;
import data.account.CurrentAccount;
import data.account.SavingsAccount;
import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AccountModel {


    // Get Account by Id
    public static Account getAccount(int id) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM accounts WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(id));

        ResultSet set = statement.executeQuery();

        if (set.next()) {
            return generateAccount(set);
        }
        return null;
    }

    public static List<Account> getAccounts() throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM accounts";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();

        LinkedList<Account> accounts = new LinkedList<>();

        while (set.next()) {
            accounts.push(generateAccount(set));
        }

        return accounts;
    }

    public static Account getAccountByCustomer(int id) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM accounts WHERE userid=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(id));

        ResultSet set = statement.executeQuery();

        if (set.next()) {
            return generateAccount(set);
        }
        return null;
    }

    // Create Account
    public static void createAccount(Account account) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "INSERT INTO accounts (userid, accountType, balance) " +
                "VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(account.getCustomerId()));
        statement.setString(2, account.getAccountType().name());
        statement.setString(3, String.valueOf(account.getBalance()));

        statement.executeUpdate();
        System.out.println("Created Account Successfully");
    }

    // Update Account
    public static void updateAccount(int accountId, int customerId) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "UPDATE accounts SET userid=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(customerId));
        statement.setString(2, String.valueOf(accountId));

        statement.execute();
    }

    public static void updateAccountBalance(int accountId, double amount) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "UPDATE accounts SET balance=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(amount));
        statement.setString(2, String.valueOf(accountId));

        statement.execute();
    }

    private static Account generateAccount(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        int userId = set.getInt("userId");
        double balance = set.getDouble("balance");
        String type = set.getString("accountType");

        System.out.println(id);
        System.out.println(userId);
        System.out.println(balance);
        System.out.println(type);

        if (type.equals(AccountType.CURRENT.name())) {
            System.out.println("Current Account");
            return new CurrentAccount(id, userId, balance, AccountType.CURRENT);
        } else if (type.equals(AccountType.SAVINGS.name())) {
            return new SavingsAccount(id, userId, balance, AccountType.SAVINGS);
        }

        return null;
    }
}
