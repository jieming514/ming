package com.ming.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 * @author jie_ming514
 */
public class DateUtils {
    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    /**
     * 日期格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取时间
     * @return
     */
    public static Date dateNow() {
        return new Date();
    }

    /**
     * 日期格式化（默认）
     */
    public static String formatDate(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 时间格式化（默认）
     */
    public static String formatDateTime(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 时间格式化
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 获取年
     * @param date
     * @return
     */
    public static int year(Date date) {
        return getField(date, Calendar.YEAR);
    }

    /**
     * 获取月
     */
    public static int month(Date date) {
        return getField(date, Calendar.MONTH);
    }

    /**
     * 获取季度
     */
    public static int quarter(Date date) {
        return month(date) / 3 + 1;
    }

    /**
     * 获取时间的某一部分
     * @return
     */
    public static int getField(Date date, int field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(field);
    }

    /**
     * 日偏移
     * @param offset
     * @return
     */
    public static Date offsetDay(Date date, int offset) {
        return offset(date, Calendar.DAY_OF_YEAR, offset);
    }

    /**
     * 周偏移
     * @param offset
     * @return
     */
    public static Date offsetWeek(Date date, int offset) {
        return offset(date, Calendar.WEEK_OF_YEAR, offset);
    }

    /**
     * 月偏移
     * @param offset
     * @return
     */
    public static Date offsetMonth(Date date, int offset) {
        return offset(date, Calendar.MONTH, offset);
    }

    /**
     * 年偏移
     * @param offset
     * @return
     */
    public static Date offsetYear(Date date, int offset) {
        return offset(date, Calendar.YEAR, offset);
    }


    /**
     * 时间偏移
     * @param datePart
     * @param offset
     * @return
     */
    public static Date offset(Date date, int datePart, int offset) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(datePart, offset);
        return cal.getTime();
    }

    /**
     * 计算距离现在多久，非精确
     *
     * @param date
     * @return
     */
    public static String getTimeBefore(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        } else if (hour > 0) {
            r += hour + "小时";
        } else if (min > 0) {
            r += min + "分";
        } else if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 计算距离现在多久，精确
     *
     * @param date
     * @return
     */
    public static String getTimeBeforeAccurate(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        }
        if (hour > 0) {
            r += hour + "小时";
        }
        if (min > 0) {
            r += min + "分";
        }
        if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 获取今天日期，时间格式默认
     * @return
     */
    public static String today() {
        return formatDate(dateNow());
    }


    /**
     * 获取实时时间，格式默认
     * @return
     */
    public static String now() {
        return formatDateTime(new Date());
    }

    /**
     * 昨天
     */
    public static Date yesterday() {
        return offsetDay(dateNow(),-1);
    }

    /**
     * 明天
     */
    public static Date tomorrow() {
        return offsetDay(dateNow(),1);
    }

    /**
     * 上周
     */
    public static Date lastWeek() {
        return offsetWeek(dateNow(), -1);
    }

    /**
     * 下周
     */
    public static Date nextWeek() {
        return offsetWeek(dateNow(), 1);
    }

    /**
     * 上个月
     */
    public static Date lastMonth() {
        return offsetMonth(dateNow(), -1);
    }

    /**
     * 下个月
     */
    public static Date nextMonth() {
        return offsetMonth(dateNow(), 1);
    }

    /**
     * 去年
     */
    public static Date lastYear() {
        return offsetYear(dateNow(), -1);
    }

    /**
     * 明年
     */
    public static Date nextYear() {
        return offsetYear(dateNow(), 1);
    }

}
