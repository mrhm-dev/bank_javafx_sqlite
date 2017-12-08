package data.account;

import data.Log;

import java.util.Date;

public class CurrentAccount extends Account{

    public CurrentAccount(int id, int customerId, double balance, AccountType accountType) {
        super(id, customerId, balance, accountType);
    }

    public CurrentAccount(int customerId, double balance, AccountType accountType) {
        super(customerId, balance, accountType);
    }

    public CurrentAccount() {
    }

    // TODO - 1 Database Update logic will add soon

    // return current balance
    public double deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        return balance;
    }

    // return current balance
    public double withdraw(double amount) {
        if (balance > amount + 500) {
            balance -= amount;
        }

        return balance;
    }

    public double sendMoney(Account account, double amount) {
        if (balance > amount + 500) {
            account.balance += amount;
            balance -= amount;
        }
        return balance;
    }
}

