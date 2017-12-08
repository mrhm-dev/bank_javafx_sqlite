package data.loan;

public abstract class Loan {

    protected String loanId;
    protected String accountId;
    protected String customerId;
    protected LoanType loanType;
    protected double loanAmount;
    protected int interest;
    protected int targetMonth;
    protected double monthlyInstalment;
    protected long creatingDate;

    // Constructor
    public Loan(String accountId, String customerId, LoanType loanType) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.loanType = loanType;
    }

    // abstract classes related with loan
    public abstract void makeLoan(double loanAmount, int targetMonth);
    public abstract double calculateReturn();
    public abstract double calculateInterest();

    public String getLoanId() {
        return loanId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getInterest() {
        return interest;
    }

    public int getTargetMonth() {
        return targetMonth;
    }

    public double getMonthlyInstalment() {
        return monthlyInstalment;
    }

    public long getCreatingDate() {
        return creatingDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", loanType=" + loanType +
                ", loanAmount=" + loanAmount +
                ", interest=" + interest +
                ", targetMonth=" + targetMonth +
                ", monthlyInstalment=" + monthlyInstalment +
                ", creatingDate=" + creatingDate +
                '}';
    }
}
