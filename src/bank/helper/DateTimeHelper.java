package bank.helper;

import java.util.Date;

public class DateTimeHelper {

    // Calculate Difference Between Two Dates and Return Month Difference
    public static Dater monthDef(Date now, Date then) {
        long mili = now.getTime() - then.getTime();
        long second = mili / 1000;
        long minute = second / 60;
        long hour = minute / 60;
        long day = hour / 24;
        long month = day / 30;
        long year = month / 12;

        return new Dater(mili, second, minute, hour, day, month, year);
    }
}
