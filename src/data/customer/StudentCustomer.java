package data.customer;

import data.account.AccountType;
import data.account.CurrentAccount;

import java.util.UUID;

public class StudentCustomer extends Customer {

    // Constructor
    public StudentCustomer(String name, String email, String password, long birthDate) {
        super(name, email, password, birthDate);
        customerType = CustomerType.STUDENT;
    }

    public StudentCustomer(String name, int id, String email, String password, int accountId, long birthDate, CustomerType customerType) {
        super(name, id, email, password, accountId, birthDate, customerType);
    }

    public StudentCustomer() {
    }

    @Override
    public String toString() {
        return "StudentCustomer{" +
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
