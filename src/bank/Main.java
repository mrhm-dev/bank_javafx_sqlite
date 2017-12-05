package bank;

import bank.account.AccountType;
import bank.customer.Customer;
import bank.customer.RegularCustomer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException, ParseException {

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date date = format.parse("01/25/1997");

        RegularCustomer customer = new RegularCustomer("Shegufa Taranjum", "shegufa.mim@gmail.com", "123456", AccountType.CURRENT, date.getTime());

        customer.createAccount();

        System.out.println(customer);
    }
}
