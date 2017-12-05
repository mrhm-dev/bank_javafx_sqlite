package bank;

import bank.account.AccountType;
import bank.customer.Customer;
import bank.customer.RegularCustomer;
import bank.loan.HomeLoan;
import bank.loan.LoanType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException, ParseException {

        HomeLoan loan = new HomeLoan("233sdfd", "fssdf23", LoanType.HOME, 5, 600000);

        loan.makeLoan(2000000, 120);

        System.out.println("Return Amount " + loan.calculateReturn());

        System.out.println(loan);
    }
}
