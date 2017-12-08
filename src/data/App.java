package data;

import data.account.Account;
import data.account.AccountType;
import data.customer.Customer;
import data.customer.CustomerType;
import data.customer.StudentCustomer;
import db.DatabaseConnection;
import model.AccountModel;
import model.CustomerModel;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class App {

    public static void main(String[] args) throws Exception {

//        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
//        Date date = format.parse("11/21/1995");
//
//        Customer customer = new Customer("HM Nayem", 3, "hm.nayem@gmail.com",
//                "pas2323", 3, date.getTime(), CustomerType.REGULAR);
//
//        CustomerModel.createCustomer(customer);
//
//        System.out.println(CustomerModel.getCustomer("hm.nayem@gmail.com"));

//        List<Customer> customers = CustomerModel.getCustomers();
//
//        System.out.println(customers);

        Account account = AccountModel.getAccountByCustomer(99999);

        System.out.println(account);

    }
}
