package data.customer;

import data.account.AccountType;

public class Customer {

    protected String name;
    protected int id;
    protected String email;
    protected String password;
    protected int accountId;
    protected long birthDate;
    protected CustomerType customerType;

    // Constructor

    public Customer() {

    }

    public Customer(String name, String email, String password, long birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Customer(String name, int id, String email, String password, int accountId, long birthDate, CustomerType customerType) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.accountId = accountId;
        this.birthDate = birthDate;
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountId() {
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
                ", accountId='" + accountId + '\'' +
                ", birthDate=" + birthDate +
                ", customerType=" + customerType +
                '}';
    }
}
