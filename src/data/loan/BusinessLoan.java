package data.loan;

import java.util.Date;
import java.util.UUID;

public class BusinessLoan extends Loan {

    public static final int INTEREST = 7;

    public BusinessLoan(int loanId, int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth, double monthlyInstalment, long creatingDate) {
        super(loanId, accountId, customerId, loanType, loanAmount, interest, targetMonth, monthlyInstalment, creatingDate);
    }

    public BusinessLoan(int accountId, int customerId, LoanType loanType, double loanAmount, int interest, int targetMonth) {
        super(accountId, customerId, loanType, loanAmount, interest, targetMonth);
    }

    public BusinessLoan() {
    }

    @Override
    public String toString() {
        return "BusinessLoan{" +
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
