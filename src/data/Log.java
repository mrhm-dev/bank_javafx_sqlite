package data;

import java.util.Date;

public class Log {

    private String accountNumber;
    private String action;
    private long time;
    private String sign;
    private double amount;


    public Log(String accountNumber, String action, long time, String sign, double amount) {
        this.accountNumber = accountNumber;
        this.action = action;
        this.time = time;
        this.sign = sign;
        this.amount = amount;
    }

    public Log(String accountNumber, String action, long time, String sign) {
            this.accountNumber = accountNumber;
            this.action = action;
            this.time = time;
            this.sign = sign;
        }

    // Log Message
    public String message() {
        StringBuffer sb = new StringBuffer();

        sb.append("\n");
        sb.append("--------- Log ----------\n");
        sb.append(new Date(time).toString());
        sb.append(" AC: " + accountNumber + " - ");
        sb.append(action + " - ");
        sb.append(sign);
        sb.append((amount == 0 ? "No Transaction" : amount));
        sb.append("\n");

        return sb.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
