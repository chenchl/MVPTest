package com.ccl.exp.mvptest.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ccl on 2016/4/8.
 */
public class DateUtils {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat dateFormat1 = new SimpleDateFormat(
            "yyyy-MM-dd");

    /**
     * 时间格式转换1
     *
     * @param str
     * @return
     */
    public static String getDateFormatMD(String str) {

        // 替换显示格式
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long time = sdf1.parse(str).getTime();
            String date = sdf.format(new Date(time));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取时间字符串距今多少小时
     *
     * @param s
     * @return
     */
    public static String getHourByToday(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String strings = s;
        try {
            Date date = dateFormat.parse(s);
            long hour = (new Date().getTime() - date.getTime())
                    / (1000 * 60 * 60);
            long min = (new Date().getTime() - date.getTime())
                    / (1000 * 60);
            if (min < 60 && min > 1) {
                strings = min + "分钟前";
            } else if (min <= 1) {
                strings = "刚刚";
            } else if (hour < 24 && hour >= 1) {
                strings = hour + "小时前";
            } else if (hour >= 24 && hour < 96) {
                strings = hour / 24 + "天前";
            } else {
                strings = s.split(" ")[0];
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return s;
        }
        return strings;
    }

    public static boolean isToday(String s) {
        String date = dateFormat1.format(new Date());
        return TextUtils.equals(date, s);
    }

    public final static char[] upper = "零一二三四五六七八九十".toCharArray();
    public final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取指定日期是星期几
     * 参数为null时表示获取当前日期是星期几
     *
     * @param date1
     * @return
     */
    public static String getWeekOfDate(String date1) {
        Date date = null;
        int w = 0;
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        try {
            date = format.parse(date1);
            Calendar calendar = Calendar.getInstance();
            if (date != null) {
                calendar.setTime(date);
            }
            w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0) {
                w = 0;
            }
        } catch (ParseException e) {
            e.getMessage();
            return "星期一";
        }
        return weekOfDays[w];
    }

    /**
     * 根据小写数字格式的日期转换成大写格式的日期
     *
     * @param date
     * @return
     */
    public static String getUpperDate(String date) {

        String today = date;

        if (today == null) return null;
        //非数字的都去掉
        today = today.replaceAll("\\D", "");
        if (today.length() != 8) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {//年
            sb.append(upper[Integer.parseInt(today.substring(i, i + 1))]);
        }
        sb.append("年");//拼接年
        int month = Integer.parseInt(today.substring(4, 6));
        if (month <= 10) {
            sb.append(upper[month]);
        } else {
            sb.append("十").append(upper[month % 10]);
        }
        sb.append("月");//拼接月

        int day = Integer.parseInt(today.substring(6));
        if (day <= 10) {
            sb.append(upper[day]);
        } else if (day < 20) {
            sb.append("十").append(upper[day % 10]);
        } else {
            sb.append(upper[day / 10]).append("十");
            int tmp = day % 10;
            if (tmp != 0) sb.append(upper[tmp]);
        }
        sb.append("日");//拼接日
        return sb.toString();
    }

}
