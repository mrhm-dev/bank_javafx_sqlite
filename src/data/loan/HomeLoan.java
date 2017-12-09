package data.loan;

import java.util.Date;
import java.util.UUID;

public class HomeLoan extends Loan {

    public static int INTEREST = 5;

    public HomeLoan() {
    }

    public HomeLoan(int loanId, int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth, double monthlyInstalment, long creatingDate) {
        super(loanId, accountId, customerId, loanType, loanAmount, interest, targetMonth, monthlyInstalment, creatingDate);
    }

    public HomeLoan(int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth) {
        super(accountId, customerId, loanType, loanAmount, interest, targetMonth);
    }

    @Override
    public String toString() {
        return "HomeLoan{" +
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


