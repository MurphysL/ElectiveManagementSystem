package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间戳相关
 */
public class TimeUtil {

    private static final String TERM_BEGIN_END_1 = "-01-01 01:00";
    private static final String TERM_END_END_1 = "-06-30 23:59";
    private static final String TERM_BEGIN_END_2 = "-07-01 01:00";
    private static final String TERM_END_END_2 = "-12-31 23:59";

    /**
     * 获取当前学期开始与截止时间
     * @return t[0]-开始时间  t[1]-截止时间
     */
    public static long[] getTermTimeStamp(){
        long[] t = new long[2];
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String term_begin = "";
        String term_end = "";

        if(month >= 1 && month <= 6){
            term_begin = year + TERM_BEGIN_END_1;
            term_end = year + TERM_END_END_1;
        }else{
            term_begin = year + TERM_BEGIN_END_2;
            term_end = year + TERM_END_END_2;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            t[0] = format.parse(term_begin).getTime()/1000;
            t[1] = format.parse(term_end).getTime()/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return t;
    }
}
