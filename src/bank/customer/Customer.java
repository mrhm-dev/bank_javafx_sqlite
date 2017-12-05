package bank.customer;

import bank.account.AccountType;

public abstract class Customer {

    protected String name;
    protected String id;
    protected String email;
    protected String password;
    protected AccountType accountType;
    protected String accountId;
    protected long birthDate;
    protected CustomerType customerType;

    // Constructor
    public Customer(String name, String email, String password, AccountType accountType, long birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.birthDate = birthDate;
    }

    public abstract void createAccount();

    @Override
    public String toString() {
        return "Customer{" +
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
