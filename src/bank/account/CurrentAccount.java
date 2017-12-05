package bank.account;

import java.util.Date;

public class CurrentAccount extends Account{


    // Constructor
    public CurrentAccount(String accountNumber, String accountHolderNumber) {
        super(accountNumber, accountHolderNumber);
    }

    // Deposit and return updated balance
    public double deposit(double amount){
        balance += amount;
        System.out.println("Deposit " + amount + " ; Current Balance " + balance);

        Log log = new Log(accountNumber, "Deposit", new Date().getTime(), "+", amount);
        System.out.println(log.message());
        return balance;
    }

    // withdraw and return updated balance
    public double withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdraw " + amount + " ; Current Balance " + balance);

        Log log = new Log(accountNumber, "Withdraw", new Date().getTime(), "-", amount);
        System.out.println(log.message());
        return balance;
    }

    // send amount to another account from account number
    // and return updated balance

    //  TODO 1: Update sendMoney Method with account Number and Database
    public double sendMoney(CurrentAccount account, double amount) {
        if (balance > (amount + 500)) {
            balance -= amount;
            account.balance += amount;
            System.out.println("Send Money " + amount);

            Log log = new Log(accountNumber, "Send Money", new Date().getTime(), "-", amount);
            System.out.println(log.message());

            return balance;
        }else {
            System.out.println("Not Enough Money to send");
        }
        return 0;
    }
}
