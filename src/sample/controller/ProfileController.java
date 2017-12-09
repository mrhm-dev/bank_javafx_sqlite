package sample.controller;

import data.account.Account;
import data.account.AccountType;
import data.account.CurrentAccount;
import data.customer.Customer;
import data.customer.CustomerType;
import data.loan.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.AccountModel;
import model.LoanModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;


public class ProfileController implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loanTypeComboBox.getItems().addAll(LoanType.HOME, LoanType.STUDY, LoanType.BUSINESS);

        displayLoanInfo.setVisible(false);
        loanInterestLabel.setVisible(false);

        noLoan.setVisible(false);
        loanStatusBox.setVisible(false);
    }

    private Customer customer;
    private Account account;

    // General Information goes Here

    @FXML
    private Label generalSectionName;

    @FXML
    private Label generalSectionEmail;

    @FXML
    private Label generalSectionBirthDay;

    @FXML
    private Label generalSectionBalance;

    @FXML
    private Label generalSectionCustomerType;

    @FXML
    private Label generalSectionAccountNumber;


    public void setCustomer(Customer customer) throws SQLException {
        this.customer = customer;

        account = AccountModel.getAccount(customer.getAccountId());

        generalSectionName.setText(customer.getName());
        generalSectionEmail.setText(customer.getEmail());
        generalSectionBirthDay.setText(new Date(customer.getBirthDate()).toString());
        generalSectionBalance.setText(String.valueOf(account.getBalance()));
        generalSectionCustomerType.setText(customer.getCustomerType().name());
        generalSectionAccountNumber.setText(String.valueOf(customer.getAccountId()));
    }


    // Logout From The System
    public void logout(ActionEvent actionEvent) throws IOException {

        Parent homepage = FXMLLoader.load(getClass().getResource("/fxml/homescreen.fxml"));
        Scene scene = new Scene(homepage);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }




    /**************************************
     *
     *
     *
     * Withdraw Section Goes Here
     *
     *
     * ************************************/

    @FXML
    private TextField withdrawAmount;

    @FXML
    private PasswordField withdrawPassword;

    @FXML
    private Label withdrawSuccessLabel;

    @FXML
    private Label withdrawFailedLabel;

    // Make Withdraw Method
    public void makeWithdraw(ActionEvent actionEvent) throws SQLException {

        withdrawFailedLabel.setVisible(false);
        withdrawSuccessLabel.setVisible(false);

        double amount = Double.parseDouble(withdrawAmount.getText());
        String password = withdrawPassword.getText();

        if (password.equals(customer.getPassword())) {
            if (account.getAccountType() == AccountType.CURRENT) {
                CurrentAccount ac = (CurrentAccount) account;
                double balance = ac.withdraw(amount);
                generalSectionBalance.setText(String.valueOf(balance));
                withdrawSuccessLabel.setVisible(true);
                withdrawAmount.setText("");
                withdrawPassword.setText("");
            }
        } else {
            System.out.println("Withdraw Failed");
            withdrawFailedLabel.setVisible(true);
        }

    }

    /**************************************
     *
     *
     *
     * Deposite Section Goes Here
     *
     *
     * ************************************/

    @FXML
    private TextField depositeAmount;

    @FXML
    private PasswordField depositePassword;

    @FXML
    private Label depositeSuccessLabel;

    @FXML
    private Label depositeFailedLabel;

    // Make Withdraw Method
    public void makeDeposite(ActionEvent actionEvent) throws SQLException {

        depositeFailedLabel.setVisible(false);
        depositeSuccessLabel.setVisible(false);

        double amount = Double.parseDouble(depositeAmount.getText());
        String password = depositePassword.getText();

        if (password.equals(customer.getPassword())) {
            if (account.getAccountType() == AccountType.CURRENT) {
                CurrentAccount ac = (CurrentAccount) account;
                double balance = ac.deposit(amount);
                generalSectionBalance.setText(String.valueOf(balance));
                depositeSuccessLabel.setVisible(true);
                depositeAmount.setText("");
                depositePassword.setText("");
            }
        } else {
            System.out.println("Deposite Failed");
            depositeFailedLabel.setVisible(true);
        }

    }


    /**************************************
     *
     *
     *
     * Deposite Section Goes Here
     *
     *
     * ************************************/

    @FXML
    private TextField sendAmount;

    @FXML
    private PasswordField sendPassword;

    @FXML
    private TextField sendId;

    @FXML
    private Label sendSuccessLabel;

    @FXML
    private Label sendFailedLabel;

    // Make Withdraw Method
    public void sendMoney(ActionEvent actionEvent) throws SQLException {

        sendSuccessLabel.setVisible(false);
        sendFailedLabel.setVisible(false);

        double amount = Double.parseDouble(sendAmount.getText());
        String password = sendPassword.getText();
        int id = Integer.parseInt(sendId.getText());
        if (password.equals(customer.getPassword())) {
            if (account.getAccountType() == AccountType.CURRENT) {
                CurrentAccount ac = (CurrentAccount) account;
                double balance = ac.sendMoney(id, amount);
                generalSectionBalance.setText(String.valueOf(balance));
                sendSuccessLabel.setVisible(true);
                sendAmount.setText("");
                sendPassword.setText("");
                sendId.setText("");
            }
        } else {
            System.out.println("Deposite Failed");
            sendFailedLabel.setVisible(true);
        }

    }


    /**************************************
     *
     *
     *
     * Creating Loan Section
     *
     *
     * ************************************/

    @FXML
    private ComboBox<LoanType> loanTypeComboBox;

    @FXML
    private TextField loanAmountField;

    @FXML
    private TextField targetMonthField;

    @FXML
    private Label loanInterestLabel;

    @FXML
    private HBox displayLoanInfo;

    @FXML
    private Label loanAmountLabel;

    @FXML
    private Label interestAmountLabel;

    @FXML
    private Label totalAmountLabel;

    @FXML
    private Label installmentAmountLabel;

    private LoanType selectedLoanType;


    public void getSelectedLoanType(ActionEvent actionEvent) {

        selectedLoanType = loanTypeComboBox.getValue();
        String message = "";
        if (selectedLoanType == LoanType.HOME) {
            message = "Home Loan Interest " + HomeLoan.INTEREST + "%";
        } else if (selectedLoanType == LoanType.STUDY) {
            message = "Study Loan Interest " + StudyLoan.INTEREST + "%";
        } else if (selectedLoanType == LoanType.BUSINESS) {
            message = "Business Loan Interest " + BusinessLoan.INTEREST + "%";
        }

        loanInterestLabel.setText(message);
        loanInterestLabel.setVisible(true);

    }

    public void createLoan(ActionEvent actionEvent) throws SQLException {

        double amount = Double.parseDouble(loanAmountField.getText());
        int targetMonth = Integer.parseInt(targetMonthField.getText());

        Loan loan = null;

        if (customer.getCustomerType() == CustomerType.STUDENT && selectedLoanType == LoanType.STUDY) {
            loan = new StudyLoan(customer.getAccountId(), customer.getId(), selectedLoanType, amount, StudyLoan.INTEREST, targetMonth);
        } else if (customer.getCustomerType() != CustomerType.STUDENT) {
            if (selectedLoanType == LoanType.HOME) {
                loan = new HomeLoan(customer.getAccountId(), customer.getId(), selectedLoanType, amount, StudyLoan.INTEREST, targetMonth);
            } else if (selectedLoanType == LoanType.BUSINESS){
                loan = new StudyLoan(customer.getAccountId(), customer.getId(), selectedLoanType, amount, StudyLoan.INTEREST, targetMonth);
            }
        } else {
            System.out.println("Type Not Matched");
            System.out.println("Student Can't Get Loan Except Study Loan");
        }

        LoanModel.createLoan(loan);

        loanAmountLabel.setText(String.valueOf(loan.getLoanAmount()));
        interestAmountLabel.setText(String.valueOf(loan.calculateInterest()));
        totalAmountLabel.setText(String.valueOf((loan.calculateInterest() + loan.getLoanAmount())));
        installmentAmountLabel.setText(String.valueOf(loan.getMonthlyInstalment()));

        displayLoanInfo.setVisible(true);
    }


    /**************************************
     *
     *
     *
     * Loan Status Section
     *
     *
     * ************************************/

    @FXML
    private Label loanStatusAmount;

    @FXML
    private Label loanStatusInterest;

    @FXML
    private Label loanStatusTotalAmount;

    @FXML
    private Label loanStatusMonthlyInstallment;

    @FXML
    private Label noLoan;

    @FXML
    private HBox loanStatusBox;

    public void showLoanData(Event event) {
        try {
            Loan loan = LoanModel.getLoan(customer.getId());

            if (loan == null) {
                noLoan.setVisible(true);
            } else {
                loanStatusAmount.setText(String.valueOf(loan.getLoanAmount()));
                loanStatusInterest.setText(String.valueOf(loan.calculateInterest()));
                loanStatusTotalAmount.setText(String.valueOf((loan.calculateInterest() + loan.getLoanAmount())));
                loanStatusMonthlyInstallment.setText(String.valueOf(loan.getMonthlyInstalment()));
                loanStatusBox.setVisible(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
