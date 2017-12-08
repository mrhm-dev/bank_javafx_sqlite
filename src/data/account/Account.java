package data.account;

import java.util.Date;

public class Account {

    protected int id;
    protected int customerId;
    protected double balance;
    protected AccountType accountType;

    public Account(int id, int customerId, double balance, AccountType accountType) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account(int customerId, double balance, AccountType accountType) {
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Account() {

    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
