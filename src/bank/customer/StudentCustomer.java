package bank.customer;

import bank.account.AccountType;
import bank.account.CurrentAccount;
import bank.account.SavingsAccount;

import java.util.UUID;

public class StudentCustomer extends Customer {

    // Constructor
    public StudentCustomer(String name, String email, String password, AccountType accountType, long birthDate) {
        super(name, email, password, accountType, birthDate);
        customerType = CustomerType.STUDENT;
    }

    @Override
    public void createAccount() {
        id = UUID.randomUUID().toString();
        String accountId = UUID.randomUUID().toString();

        if (accountType == AccountType.CURRENT) {

            CurrentAccount account = new CurrentAccount(accountId, id);
            // Must deposit minimum 5000 Taka for Students
            account.deposit(500);
            this.accountId = accountId;

        } else {
            System.out.println("Students Are Only Allowed to Create Current Account");
        }
        // TODO-3 Account information Will Store to Database
    }

    @Override
    public String toString() {
        return "StudentCustomer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountType=" + accountType +
                ", accountId='" + accountId + '\'' +
                ", birthDate=" + birthDate +
                ", customerType=" + customerType +
                '}';
    }
}
