package data.loan;

import java.util.Date;

public class Loan {

    protected int loanId;
    protected int accountId;
    protected int customerId;
    protected LoanType loanType;
    protected double loanAmount;
    protected int interest;
    protected int targetMonth;
    protected double monthlyInstalment;
    protected long creatingDate;

    public Loan(int loanId, int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth, double monthlyInstalment, long creatingDate) {
        this.loanId = loanId;
        this.accountId = accountId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interest = interest;
        this.targetMonth = targetMonth;
        this.monthlyInstalment = monthlyInstalment;
        this.creatingDate = creatingDate;
    }

    public Loan(int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interest = interest;
        this.targetMonth = targetMonth;
        this.monthlyInstalment = (loanAmount + calculateInterest()) / targetMonth;
        this.creatingDate = new Date().getTime();
    }

    public Loan() {

    }

    public double calculateInterest() {
        double monthlyInterest = interest / 12.0;
        double interest = loanAmount * monthlyInterest * targetMonth / 100;
        return interest;
    }

    public int getLoanId() {
        return loanId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCustomerId() {
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

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public void setTargetMonth(int targetMonth) {
        this.targetMonth = targetMonth;
    }

    public void setMonthlyInstalment(double monthlyInstalment) {
        this.monthlyInstalment = monthlyInstalment;
    }

    public void setCreatingDate(long creatingDate) {
        this.creatingDate = creatingDate;
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
