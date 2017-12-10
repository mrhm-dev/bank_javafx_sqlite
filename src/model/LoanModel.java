package model;

import data.loan.*;
import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LoanModel {

    // Get Loan By Customer Id
    public static Loan getLoan(int customerId) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM loans WHERE userid=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(customerId));

        ResultSet set = statement.executeQuery();

        if (set.next()) {
            return generateLoan(set);
        }
        return null;

    }

    public static List<Loan> getLoans() throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM loans";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();

        LinkedList<Loan> loans = new LinkedList<>();

        while (set.next()) {
            loans.push(generateLoan(set));
        }

        return loans;
    }

    // Create Loan from Loan Object
    public static void createLoan(Loan loan) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "INSERT INTO loans (userid, accountid, loantype, loanamount, interest, targetmonth, creatingdate, monthlyinstalment) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(loan.getCustomerId()));
        statement.setString(2, String.valueOf(loan.getAccountId()));
        statement.setString(3, loan.getLoanType().name());
        statement.setString(4, String.valueOf(loan.getLoanAmount()));
        statement.setString(5, String.valueOf(loan.getInterest()));
        statement.setString(6, String.valueOf(loan.getTargetMonth()));
        statement.setString(7, String.valueOf(loan.getCreatingDate()));
        statement.setString(8, String.valueOf(loan.getMonthlyInstalment()));

        statement.executeUpdate();
        System.out.println("Loan Created Successfully");
    }

    private static Loan generateLoan(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        int userId = set.getInt("userid");
        int accountId = set.getInt("accountid");
        String loantype = set.getString("loantype");
        double amount = set.getDouble("loanamount");
        int interest = set.getInt("interest");
        int targetMonth = set.getInt("targetmonth");
        double monthlyInstallment = set.getDouble("monthlyinstalment");
        long creatingDate = set.getLong("creatingdate");

        Loan loan = null;

        if (loantype.equals(LoanType.STUDY.name())) {
            loan = new StudyLoan(id, accountId, userId, LoanType.STUDY, amount, interest, targetMonth, monthlyInstallment, creatingDate);
        } else if (loantype.equals(LoanType.HOME.name())) {
            loan = new HomeLoan(id, accountId, userId, LoanType.STUDY, amount, interest, targetMonth, monthlyInstallment, creatingDate);
        } else if (loantype.equals(LoanType.BUSINESS.name())) {
            loan = new BusinessLoan(id, accountId, userId, LoanType.STUDY, amount, interest, targetMonth, monthlyInstallment, creatingDate);
        }

        return loan;
    }
}



















