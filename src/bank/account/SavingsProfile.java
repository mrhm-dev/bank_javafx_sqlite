package bank.account;

import java.util.Date;

public class SavingsProfile {

    private int id;
    private double amount;
    private int month;
    private int interest;
    private long creatingDate;
    private int withdrawMonth;

    public SavingsProfile(int id, double amount, int month, int interest, int withdrawMonth) {
        this.id = id;
        this.amount = amount;
        this.month = month;
        this.interest = interest;
        this.creatingDate = new Date().getTime();
        this.withdrawMonth = withdrawMonth;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public int getMonth() {
        return month;
    }

    public int getInterest() {
        return interest;
    }

    public long getCreatingDate() {
        return creatingDate;
    }

    public int getWithdrawMonth() {
        return withdrawMonth;
    }

    // Return Total Returned Amount
    public double getTotalReturnAmount(int month) {
        double interest = getMonthlyInterest() * month * amount;
        return amount + interest;
    }

    // return monthly interest
    private double getMonthlyInterest() {
        return interest / 12;
    }
}
