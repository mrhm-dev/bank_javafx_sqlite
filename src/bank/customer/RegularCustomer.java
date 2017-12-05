package bank.customer;

import bank.account.AccountType;
import bank.account.CurrentAccount;
import bank.account.SavingsAccount;

import java.util.UUID;

public class RegularCustomer extends Customer {

    // Constructor
    public RegularCustomer(String name, String email, String password, AccountType accountType, long birthDate) {
        super(name, email, password, accountType, birthDate);
        customerType = CustomerType.REGULAR;
    }

    // Create Specific Account provided by the user
    @Override
    public void createAccount() {

        id = UUID.randomUUID().toString();
        String accountId = UUID.randomUUID().toString();

        if (accountType == AccountType.CURRENT) {

            CurrentAccount account = new CurrentAccount(accountId, id);
            // Must deposit minimum 1000 Taka
            account.deposit(1000);
            this.accountId = accountId;

        } else if (accountType == AccountType.SAVINGS) {
            SavingsAccount account = new SavingsAccount(accountId, id);
            this.accountId = accountId;
        } else {
            System.out.println("You Have to Select Either Current or Savings");
        }
        // TODO-2 Account information Will Store to Database
    }

    @Override
    public String toString() {
        return "RegularCustomer{" +
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
