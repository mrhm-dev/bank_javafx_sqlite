package data.customer;

import data.account.AccountType;
import data.account.CurrentAccount;
import data.account.SavingsAccount;

import java.util.UUID;

public class RegularCustomer extends Customer {

    // Constructor

    public RegularCustomer() {
    }

    public RegularCustomer(String name, String email, String password, long birthDate) {
        super(name, email, password, birthDate);
    }

    public RegularCustomer(String name, int id, String email, String password, int accountId, long birthDate, CustomerType customerType) {
        super(name, id, email, password, accountId, birthDate, customerType);
    }


    // Create Specific Account provided by the user
    // Return Account Id as String

    @Override
    public String toString() {
        return "RegularCustomer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountId='" + accountId + '\'' +
                ", birthDate=" + birthDate +
                ", customerType=" + customerType +
                '}';
    }
}
