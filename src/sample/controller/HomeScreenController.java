package sample.controller;

import data.account.Account;
import data.account.AccountType;
import data.account.CurrentAccount;
import data.customer.Customer;
import data.customer.CustomerType;
import data.customer.RegularCustomer;
import data.customer.StudentCustomer;
import data.helper.DateTimeHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.AccountModel;
import model.CustomerModel;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable {

    // User Registration and It's Related Variables Goes Here

    private final int DUMMY = 99999;

    @FXML
    private TextField createAccountName;

    @FXML
    private TextField createAccountEmail;

    @FXML
    private PasswordField createAccountPassword;

    @FXML
    private DatePicker createAccountDate;

    @FXML
    private ComboBox<CustomerType> createAccountYouAre;

    @FXML
    private ComboBox<AccountType> createAccountAccountType;

    @FXML
    private Label accountCreatedLabel;

    private AccountType accountType;
    private CustomerType customerType;
    /*
    * All Method Related To User Account Creation
    */

    public void getWhoYouAre(ActionEvent actionEvent) {
        customerType = createAccountYouAre.getValue();
    }

    public void getAccountType(ActionEvent actionEvent) {
        accountType = createAccountAccountType.getValue();
    }

    // Create a New User Account
    public void createAccount(ActionEvent actionEvent) throws Exception {

        String name = createAccountName.getText();
        String email = createAccountEmail.getText();
        String password = createAccountPassword.getText();
        // Convert LocalDate to Date
        Date date = DateTimeHelper.localDatetoDate(createAccountDate.getValue());

        Customer customer = null;

        if (customerType == CustomerType.STUDENT) {

            if (accountType == AccountType.CURRENT) {

                Account account = new CurrentAccount(DUMMY, 500, accountType);
                AccountModel.createAccount(account);
                account = AccountModel.getAccountByCustomer(DUMMY);

                customer = new StudentCustomer(name, DUMMY, email, password, account.getId(), date.getTime(), CustomerType.STUDENT);

                CustomerModel.createCustomer(customer);

                customer = CustomerModel.getCustomer(email);

                AccountModel.updateAccount(customer.getAccountId(), customer.getId());

                clearRegField();

            } else {
                System.out.println(("Student Can only Create Current Account"));
            }

        } else if (customerType == CustomerType.REGULAR) {
            Account account = new CurrentAccount(DUMMY, 1000, accountType);
            AccountModel.createAccount(account);
            account = AccountModel.getAccountByCustomer(DUMMY);
            customer = new RegularCustomer(name, 1, email, password, account.getId(), date.getTime(), CustomerType.REGULAR);
            CustomerModel.createCustomer(customer);
            customer = CustomerModel.getCustomer(email);
            AccountModel.updateAccount(customer.getAccountId(), customer.getId());

            clearRegField();

        } else {
            customer = null;
        }

        clearRegField();
    }

    // Clear All Field
    private void clearRegField() {
        createAccountName.setText("");
        createAccountEmail.setText("");
        createAccountPassword.setText("");
    }



    // Login System and it's related variable and Method Goes Here

    @FXML
    private TextField loginEmail;

    @FXML
    private PasswordField loginPassword;


    public void changeLoginType(ActionEvent actionEvent) {

        // TODO Login Type will Goes Here
    }

    public void getLogin(ActionEvent actionEvent) throws Exception {

        String email = loginEmail.getText();
        String password = loginPassword.getText();

        Customer customer = CustomerModel.getCustomer(email);

        if (customer != null) {
            if (customer.getPassword().equals(password)) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/profile.fxml"));
                Parent profile = loader.load();
                Scene scene = new Scene(profile);

                ProfileController controller = loader.getController();
                controller.setCustomer(customer);

                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.setResizable(false);
                window.show();
            }
        }
    }

    /*
    * Initialize All Necessary Information here.
    * This is override Method from Initializable Interface
    */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add Customer Type To ComboBox
        createAccountYouAre.getItems().addAll(CustomerType.REGULAR, CustomerType.STUDENT);

        // Add Account Type To ComboBox
        createAccountAccountType.getItems().addAll(AccountType.CURRENT, AccountType.SAVINGS);

    }
}
