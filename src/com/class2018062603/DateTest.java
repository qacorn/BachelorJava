package com.class2018062603;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {

    public static void main(String[] args) {
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss",Locale.CHINA);
        System.out.println(dateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2018);
        calendar.set(Calendar.MONTH,5);
        calendar.set(Calendar.DAY_OF_MONTH,26);
        calendar.set(Calendar.HOUR_OF_DAY,8);
        Date date2 = calendar.getTime();
        long startTime = date2.getTime();
        //1529973674854
        //1300000000000
        System.out.println(startTime);
        System.out.println(calendar.getTime());
        System.out.println(dateFormat.format(calendar.getTime()));

        LocalDate localDate = LocalDate.of(2018,6,26);
        System.out.println(localDate);

        Date date9 = new Date(1600000000000L);
        System.out.println(date9);
        //Sun Sep 13 20:26:40 CST 2020

        Date date8 = new Date(1500000000000L);
        System.out.println(date8);
        //Fri Jul 14 10:40:00 CST 2017


        Date date7 = new Date(1400000000000L);
        System.out.println(date7);
        //Wed May 14 00:53:20 CST 2014

        Date date3 = new Date(1300000000000L);
        System.out.println(date3);
        //Sun Mar 13 15:06:40 CST 2011

        Date date4 = new Date(1200000000000L);
        System.out.println(date4);
        //Fri Jan 11 05:20:00 CST 2008

        Date date5 = new Date(1100000000000L);
        System.out.println(date5);
        //Tue Nov 09 19:33:20 CST 2004
    }
}
