package bank.account;

import java.util.Date;

public class Account {

    protected String accountNumber;
    protected String accountHolderNumber;
    protected double balance;

    public Account(String accountNumber, String accountHolderNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderNumber = accountHolderNumber;
    }

    // return Account Number of this account
    public String getAccountNumber() {
        return accountNumber;
    }

    // return Account Holder Number of this Account
    public String getAccountHolderNumber() {
        return accountHolderNumber;
    }

    // check current balance
    public double checkBalance() {
        System.out.println("Current Balance " + balance);

        // Creating a new Log when User check their balances and store it to database
        Log log = new Log(accountNumber, "Check Balance", new Date().getTime(), "#");
        System.out.println(log.message());
        return balance;
    }

}
