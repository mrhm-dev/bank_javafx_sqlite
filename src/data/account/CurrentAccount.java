package data.account;

import data.Log;
import model.AccountModel;

import java.sql.SQLException;
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
    public double deposit(double amount) throws SQLException {
        if (amount > 0) {
            this.balance += amount;
            AccountModel.updateAccountBalance(id, balance);
        }
        return balance;
    }

    // return current balance
    public double withdraw(double amount) throws SQLException {
        if (balance > amount + 500) {
            balance -= amount;
            AccountModel.updateAccountBalance(id, balance);
        }

        return balance;
    }

    public double sendMoney(int accountId, double amount) throws SQLException {
        if (balance > amount + 500) {
            Account account = AccountModel.getAccount(accountId);
            account.balance += amount;
            AccountModel.updateAccountBalance(accountId, account.balance);

            this.balance -= amount;
            AccountModel.updateAccountBalance(this.id, this.balance);
        }
        return balance;
    }
}

