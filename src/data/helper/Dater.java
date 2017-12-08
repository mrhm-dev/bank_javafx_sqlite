package data.helper;

public class Dater {

    public long mili;
    public long sec;
    public long min;
    public long hour;
    public long day;
    public long month;
    public long year;


    public Dater(long mili, long sec, long min, long hour, long day, long month, long year) {
        this.mili = mili;
        this.sec = sec;
        this.min = min;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Dater{" +
                "mili=" + mili +
                ", sec=" + sec +
                ", min=" + min +
                ", hour=" + hour +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
