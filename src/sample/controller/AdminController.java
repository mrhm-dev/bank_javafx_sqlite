package sample.controller;

import data.Admin;
import data.account.Account;
import data.account.AccountType;
import data.customer.Customer;
import data.customer.CustomerType;
import data.loan.Loan;
import data.loan.LoanType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.AccountModel;
import model.CustomerModel;
import model.LoanModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            viewCustomers();
            viewAccounts();
            viewLoans();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    * Customer Table Goes Here
    * */

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, Integer> customerId;

    @FXML
    private TableColumn<Customer, String> customerName;

    @FXML
    private TableColumn<Customer, String> customerEmail;

    @FXML
    private TableColumn<Customer, CustomerType> customerType;

    @FXML
    private TableColumn<Customer, Integer> customerAccountNo;


    public void viewCustomers() throws Exception {
        customerId.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        customerName.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        customerType.setCellValueFactory(new PropertyValueFactory<Customer, CustomerType>("customerType"));
        customerAccountNo.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("accountId"));

        customerTable.setItems(getCustomer());
    }


    // Account Table Goes Here

    @FXML
    private TableView<Account> accountTable;

    @FXML
    private TableColumn<Account, Integer> accountId;

    @FXML
    private TableColumn<Account, AccountType> accountType;

    @FXML
    private TableColumn<Account, Double> accountBalance;

    public void viewAccounts() throws SQLException {
        accountId.setCellValueFactory(new PropertyValueFactory<Account, Integer>("id"));
        accountType.setCellValueFactory(new PropertyValueFactory<Account, AccountType>("accountType"));
        accountBalance.setCellValueFactory(new PropertyValueFactory<Account, Double>("balance"));

        accountTable.setItems(getAccounts());
    }


    // Loan Table Goes Here

    @FXML
    private TableView<Loan> loanTable;

    @FXML
    private TableColumn<Loan, Integer> loanId;

    @FXML
    private TableColumn<Loan, Integer> loanAccountId;

    @FXML
    private TableColumn<Loan, Integer> loanCustomerId;

    @FXML
    private TableColumn<Loan, LoanType> loanType;

    @FXML
    private TableColumn<Loan, Double> loanAmount;

    @FXML
    private TableColumn<Loan, Double> loanInstallment;

    public void viewLoans() throws SQLException {
        loanId.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("loanId"));
        loanAccountId.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("accountId"));
        loanCustomerId.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("customerId"));
        loanType.setCellValueFactory(new PropertyValueFactory<Loan, LoanType>("loanType"));
        loanAmount.setCellValueFactory(new PropertyValueFactory<Loan, Double>("loanAmount"));
        loanInstallment.setCellValueFactory(new PropertyValueFactory<Loan, Double>("monthlyInstalment"));

        loanTable.setItems(getLoans());
    }


    // ALL Observable List Goes Here
    private ObservableList<Customer> getCustomer() throws Exception {

        List<Customer> customers = CustomerModel.getCustomers();
        ObservableList<Customer> observableList = FXCollections.observableArrayList();

        observableList.addAll(customers);
        return observableList;
    }

    private ObservableList<Account> getAccounts() throws SQLException {
        List<Account> accounts = AccountModel.getAccounts();
        ObservableList<Account> observableList = FXCollections.observableArrayList();

        observableList.addAll(accounts);
        return observableList;
    }

    private ObservableList<Loan> getLoans() throws SQLException {
        List<Loan> loans = LoanModel.getLoans();
        ObservableList<Loan> observableList = FXCollections.observableArrayList();

        observableList.addAll(loans);
        return observableList;
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/homescreen.fxml"));
        Scene scene = new Scene(parent);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
