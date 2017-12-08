package data.account;

import data.Log;
import data.helper.DateTimeHelper;
import data.helper.Dater;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SavingsAccount extends Account {

    public SavingsAccount(int id, int customerId, double balance, AccountType accountType) {
        super(id, customerId, balance, accountType);
    }

    public SavingsAccount(int customerId, double balance, AccountType accountType) {
        super(customerId, balance, accountType);
    }

    public SavingsAccount() {
    }
}

