package sample.controller;

import data.account.Account;
import data.customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.AccountModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;


public class ProfileController implements Initializable{

    private Customer customer;

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

        Account account = AccountModel.getAccount(customer.getAccountId());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
