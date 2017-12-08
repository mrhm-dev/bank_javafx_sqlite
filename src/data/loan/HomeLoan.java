package data.loan;

import java.util.Date;
import java.util.UUID;

public class HomeLoan extends Loan {

    private int familyMember;
    private double yearlyIncome;
    private static final int INTEREST = 5;

    public HomeLoan(String accountId, String customerId, LoanType loanType, int familyMember, double yearlyIncome) {
        super(accountId, customerId, loanType);
        this.familyMember = familyMember;
        this.yearlyIncome = yearlyIncome;
    }

    public int getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(int familyMember) {
        this.familyMember = familyMember;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    @Override
    public void makeLoan(double loanAmount, int targetMonth) {
        if (loanType == LoanType.HOME) {
            if (yearlyIncome > 500000) {

                this.loanId = UUID.randomUUID().toString();
                this.loanAmount = loanAmount;
                this.interest = INTEREST;
                this.targetMonth = targetMonth;
                this.monthlyInstalment = calculateReturn() / targetMonth;
                this.creatingDate = new Date().getTime();
                System.out.println("You have made a new Loan of " + loanAmount + " TAKA");

            } else {
                System.out.println("You are not eligible for a home loan");
            }
        }else {
            System.out.println("Home Loan is Not Complete");
        }
    }

    @Override
    public double calculateReturn() {

        return calculateInterest() + loanAmount;
    }

    @Override
    public double calculateInterest() {

        double monthlyInterest = INTEREST / 12.0;
        return loanAmount * monthlyInterest * targetMonth / 100;
    }


    @Override
    public String toString() {
        return "HomeLoan{" +
                "familyMember=" + familyMember +
                ", yearlyIncome=" + yearlyIncome +
                ", loanId='" + loanId + '\'' +
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


