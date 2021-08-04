package priv.sunyj.sms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Data {
    private static Calendar cal = Calendar.getInstance();

    public static String getYear() {
        String year = String.valueOf(cal.get(Calendar.YEAR));
        return year;
    }

}
