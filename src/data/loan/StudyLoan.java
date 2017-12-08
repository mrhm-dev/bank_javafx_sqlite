package data.loan;

import java.util.Date;
import java.util.UUID;

public class StudyLoan extends Loan{

    private static final int INTEREST = 3;

    public StudyLoan(String accountId, String customerId, LoanType loanType) {
        super(accountId, customerId, loanType);
    }

    @Override
    public void makeLoan(double loanAmount, int targetMonth) {
        if (loanType == LoanType.STUDY) {
            this.loanId = UUID.randomUUID().toString();
            this.loanAmount = loanAmount;
            this.interest = INTEREST;
            this.targetMonth = targetMonth;
            this.monthlyInstalment = calculateReturn() / targetMonth;
            this.creatingDate = new Date().getTime();
            System.out.println("You have made a new Loan of " + loanAmount + " TAKA");
        }else {
            System.out.println("Study Loan is Not Complete");
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
        return "StudyLoan{" +
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
