package data.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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

    public static Date localDatetoDate(LocalDate localDate) {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String date = "" + localDate.getMonth().getValue() + "/" + localDate.getDayOfMonth() + "/" + localDate.getYear();

        Date newDate = null;

        try {
            newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
