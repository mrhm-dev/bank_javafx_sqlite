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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getAccountId() {
        return accountId;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

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
