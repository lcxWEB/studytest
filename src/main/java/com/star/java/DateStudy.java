package com.star.java;

import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @Author: lcx
 * @Date: 2019/2/13 13:27
 * @Description:
 */

public class DateStudy {

    public static void main(String[] args) {

        Locale.setDefault(Locale.UK);

        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);

        int fisrtDayOfWeek = d.getFirstDayOfWeek();

        int indent = 0;
        while (weekday != fisrtDayOfWeek) {
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        System.out.println(weekday);
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        System.out.println(Arrays.toString(weekdayNames));
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        while (weekday != fisrtDayOfWeek);

        System.out.println();

        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            if (day == today) System.out.print("*");
            else System.out.print(" ");

            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            if (weekday == fisrtDayOfWeek) System.out.println();
        }
        while (d.get(Calendar.MONTH) == month);

        if (weekday != fisrtDayOfWeek) System.out.println();

        System.out.println(System.out);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println(currencyFormatter.format(x));
        System.out.println(percentFormatter.format(x));

    }

}
