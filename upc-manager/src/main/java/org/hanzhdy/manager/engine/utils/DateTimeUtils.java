package org.hanzhdy.manager.engine.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具类
 * @since JDK1.6
 */
public class DateTimeUtils {
    // Static fields/initializers
    private static Logger       logger          = LoggerFactory.getLogger(DateTimeUtils.class);
    
    /** 日期时间默认格式yyyy-MM-dd HH:mm:ss */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    public final static String  DATE_PATTERN    = "yyyy-MM-dd";
    
    // Mehthods
    
    /**
     * 获得当前日期
     * @return
     */
    public static String getCurrentDate() {
        return format(new Date(), "yyyy-MM-dd");
    }
    
    /**
     * 将日期字符串按默认格式转换成日期类型
     * @param strDate
     *        待转换日期字符串
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String strDate) throws ParseException {
        return StringToDate(strDate, DateTimeUtils.DEFAULT_PATTERN);
    }
    
    /**
     * 获取指定日期的结束时间
     * @param date
     * @return
     */
    public static Date getMaxDateOfDay(Date date) {
        if (date == null) {
            return null;
        }
        else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, calendar.getActualMaximum(11));
            calendar.set(12, calendar.getActualMaximum(12));
            calendar.set(13, calendar.getActualMaximum(13));
            calendar.set(14, calendar.getActualMaximum(14));
            return calendar.getTime();
        }
    }
    
    /**
     * 获取指定日期的开始时间
     * @param date
     * @return
     */
    public static Date getMinDateOfDay(Date date) {
        if (date == null) {
            return null;
        }
        else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, calendar.getActualMinimum(11));
            calendar.set(12, calendar.getActualMinimum(12));
            calendar.set(13, calendar.getActualMinimum(13));
            calendar.set(14, calendar.getActualMinimum(14));
            return calendar.getTime();
        }
    }
    
    /**
     * 将日期字符串按指定格式转换成日期类型
     * @param strDate
     *        待转换日期时间字符串
     * @param pattern
     *        输入时间格式
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String strDate, String pattern) throws ParseException {
        Date date = null;
        if (pattern == null || pattern.equals("")) {
            pattern = DateTimeUtils.DEFAULT_PATTERN;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(pattern);
        if (logger.isDebugEnabled()) {
            logger.debug("converting '" + strDate + "' to date with pattern '" + pattern + "'");
        }
        try {
            date = fmt.parse(strDate);
        }
        catch (ParseException e) {
            logger.error("ParseException: " + e);
            throw e;
        }
        return date;
    }
    
    /**
     * 将long类型日期转换成默认格式的字符串形式
     * @param date
     * @return
     */
    public static String format(long date) {
        return format(date, DateTimeUtils.DEFAULT_PATTERN);
    }
    
    /**
     * 将long类型日期转换成指定格式的字符串形式
     * @param date
     * @param pattern
     * @return
     */
    public static String format(long date, String pattern) {
        return format(new Date(date), pattern);
    }
    
    /**
     * 将日期类转换成默认格式的字符串形式
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DateTimeUtils.DEFAULT_PATTERN);
    }
    
    /**
     * 将日期类转换成指定格式的字符串形式
     * @param date
     * @param patttern
     * @return
     */
    public static String format(Date date, String patttern) {
        SimpleDateFormat df = null;
        String returnValue = "";
        
        if (date == null) {
            logger.error("date is null!");
        }
        else {
            df = new SimpleDateFormat(patttern);
            returnValue = df.format(date);
        }
        return returnValue;
    }

    /**
     * yyyyMMddHHmmss格式的字符串 转换成 指定格式的字符串形式
     * @param date
     * @return
     */
    public static String format(String date) {

        if (date != null) {
            String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";

            return date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
        }
        return "";
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(getMaxDateOfDay(new Date()));
    }
    
    // Fri Apr 25 10:38:40 CST 2014
    public static Date StringToDateForMysql(String dateString) throws ParseException {
        boolean flag = false;
        String month = null;
        String[] monthFormat = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] dateArrayString = dateString.split(" ");
        for (int i = 0; i < monthFormat.length; i++) {
            if (dateArrayString[1].equals(monthFormat[i])) {
                month = i + 1 + "";
                flag = true;
            }
            if (flag) {
                break;
            }
        }
        String newStringDateString = dateArrayString[5] + "-" + month + "-" + dateArrayString[2] + " "
                + dateArrayString[3];
        return StringToDate(newStringDateString, DateTimeUtils.DEFAULT_PATTERN);
    }
    
    public static String getYesterdayToString() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
    
    public static String getTodayToString() {
        Calendar calendar = Calendar.getInstance();
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
    
    public static String getSpecifiedDayBefore(Date specifiedDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(specifiedDay);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 获得指定日期的前一天
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    
    /**
     * 获取指定日期的最大时间
     * @param date
     * @return
     */
    public static String getMaxTimeOfDate(Date date) {
        return format(date, DATE_PATTERN) + " 23:59:59";
    }
    
    /**
     * 获取指定日期的最小时间
     * @param date
     * @return
     */
    public static String getMinTimeOfDate(Date date) {
        return format(date, DATE_PATTERN) + " 00:00:00";
    }
}
