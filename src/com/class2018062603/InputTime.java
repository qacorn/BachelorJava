package com.class2018062603;

import java.util.Calendar;
import java.util.Date;

public class InputTime {

    public static void main(String[] args) {
        InputTime inputTime = new InputTime();
//        long timeStart = inputTime.inputTime(2018, 6, 26, 8);
//        System.out.println(timeStart);
//
//        long timeEnd = inputTime.inputTime(2018,6,27,8);
//        System.out.println(timeEnd);

        long timeStamp = inputTime.getTimeStampBeforeCurrentTime(10);
        System.out.println(timeStamp);
        System.out.println(new Date(timeStamp));


    }


    /**
     *
     *
     *
     * @param year
     * @param month
     * @param dayOfMonth
     * @param hourOfDay   24小时
     */
    private long inputTime(int year,int month,int dayOfMonth,int hourOfDay) {
        if (month < 1){
            System.out.println("月份不能小于1");
            return 0;
        }

        if (month > 12){
            System.out.println("月份不能大于12");
            return 0;
        }

        if (hourOfDay < 0 ){
            System.out.println("小时不能为负数");
            return 0;
        }

        if ( hourOfDay >24){
            System.out.println("小时不能超过24");
            return 0;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month - 1);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date date = calendar.getTime();
        System.out.println(date);
        long timeStamp = date.getTime();
        return timeStamp;
    }


    private long getTimeStampBeforeCurrentTime(int beforeDay){
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
//        int year = date.getYear();
//        int month = date.getMonth();
//        int dayOfMonth = date.getDay();

        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hourOfDay);

        long todayZeroClock = inputTime(year, month + 1, dayOfMonth, 0);

        if (todayZeroClock > 0){
            long gap = (beforeDay-1)*24*60*60*1000;
            return todayZeroClock - gap;
        }


        return 0;
    }

}
