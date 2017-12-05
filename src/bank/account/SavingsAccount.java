package bank.account;

import bank.helper.DateTimeHelper;
import bank.helper.Dater;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SavingsAccount extends Account {

    private LinkedList<SavingsProfile> savings;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderNumber) {
        super(accountNumber, accountHolderNumber);
        savings = new LinkedList<>();
    }

    // create new savings profile
    public double createSavings(int id, double amount, int month, int interest, int withdrawMonth) {
        SavingsProfile profile = new SavingsProfile(id, amount, month, interest, withdrawMonth);
        savings.push(profile);

        Log log = new Log(accountNumber, "New Savings", new Date().getTime(), "+", amount);
        System.out.println(log.message());

        balance += amount;
        return balance;
    }

    // return list of Saving Profiles
    public List<SavingsProfile> getSavings() {
        return savings;
    }

    // withdraw a saving Profile
    public double withdraw(int id) {
        // search for savings profile
        SavingsProfile profile = getSavingProfile(id);

        // if profile founds
        if (profile != null) {

            Date creatingDate = new Date(profile.getCreatingDate());

            // get time difference between profile creating month and now
            Dater dater = DateTimeHelper.monthDef(new Date(), creatingDate);

            // the month difference must be greater than withdraw month
            if (dater.month < profile.getWithdrawMonth()) {
                System.out.println("You haven't reach expected time");
            } else {
                savings.remove(profile);
                balance -= profile.getAmount();

                Log log = new Log(accountNumber, "Withdraw", new Date().getTime(), "-", profile.getAmount());
                System.out.println(log.message());

//                return profile.getTotalReturnAmount((int) dater.month);
                return profile.getTotalReturnAmount(12);
            }

        }else  {
            System.out.println("Profile Doesn't Exist");
        }

        return 0;
    }


    // find savings profile by id
    private SavingsProfile getSavingProfile(int id) {
        for (SavingsProfile profile : savings) {
            if (profile.getId() == id) {
                return profile;
            }
        }

        return null;
    }
}

