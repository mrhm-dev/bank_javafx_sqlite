package data.loan;

import java.util.Date;
import java.util.UUID;

public class StudyLoan extends Loan{

    public static final int INTEREST = 3;

    public StudyLoan(int loanId, int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth, double monthlyInstalment, long creatingDate) {
        super(loanId, accountId, customerId, loanType, loanAmount, interest, targetMonth, monthlyInstalment, creatingDate);
    }
    public StudyLoan(int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth) {
        super(accountId, customerId, loanType, loanAmount, interest, targetMonth);
    }

    public StudyLoan() {
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
