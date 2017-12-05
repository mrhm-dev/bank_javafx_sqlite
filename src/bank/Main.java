package bank;

import bank.account.CurrentAccount;
import bank.helper.DateTimeHelper;
import bank.helper.Dater;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DateFormat format = new SimpleDateFormat("MM/dd/yy");

        try {
            Date birth = format.parse("11/21/1995");
            Date now = new Date();

            Dater dater = DateTimeHelper.monthDef(now, birth);
            System.out.println(dater);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
