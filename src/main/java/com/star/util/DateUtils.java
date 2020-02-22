package com.star.util;

import cn.hutool.core.util.StrUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author lcm
 */
public class DateUtils {

    /**
     * 读取excel时间进行转换
     *
     * @param use1900windowing
     * @param value
     * @return
     */
    public static String getPOIDate(boolean use1900windowing, double value) {
        int wholeDays = (int) Math.floor(value);
        int millisecondsInDay = (int) ((value - (double) wholeDays) * 8.64E7D + 0.5D);
        Calendar calendar = new GregorianCalendar();
        short startYear = 1900;
        byte dayAdjust = -1;
        if (use1900windowing) {
            startYear = 1900;
            dayAdjust = -1;
        } else if (wholeDays < 61) {
            dayAdjust = 0;
        }
        calendar.set(startYear, 0, wholeDays + dayAdjust, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, millisecondsInDay);
        if (calendar.get(Calendar.MILLISECOND) == 0) {
            calendar.clear(Calendar.MILLISECOND);
        }
        Date date = calendar.getTime();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        return s.format(date);
    }


    /**
     * 返回解析时间的数据格式
     *
     * @param str
     * @return
     */
    public static String parseDateFormate(String str, String separator) {

        int yearLength = 0;
        int monthLength = 0;
        int dayLength = 0;

        if ("中文".equals(separator)) {
            String[] year = str.split("年");
            yearLength = year[0].length();
            if (StrUtil.isNotEmpty(year[1]) && StrUtil.count(year[1], "月") > 0) {
                String[] month = year[1].split("月");
                monthLength = month[0].length();
                if (StrUtil.isNotEmpty(month[1]) && StrUtil.count(month[1], "日") > 0) {
                    String[] day = month[1].split("日");
                    dayLength = day[0].length();
                }
            }
        } else {
            String[] split = str.split(separator);
            if (split.length == 3) {
                yearLength = split[0].length();
                monthLength = split[1].length();
                dayLength = split[2].length();

            }
        }


        String year = add(yearLength, "y");
        String month = add(monthLength, "M");
        String day = add(dayLength, "d");

        String splitChart = separator.equals("中文") ? "-" : separator;
        return year + splitChart + month + splitChart + day;

    }


    /**
     * 补充符号
     *
     * @param num
     * @param chart
     * @return
     */
    public static String add(int num, String chart) {

        String str = "";
        for (int i = 0; i < num; i++) {
            str += chart;
        }
        return str;

    }

    /**
     * 用横杠替换中文
     *
     * @param value
     * @return
     */
    public static String replaceCN(String value) {
        String year = value.replace("年", "-");
        String month = year.replace("月", "-");
        String replace = month.replace("日", "");
        return replace;

    }


}
