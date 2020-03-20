package com.class062201;

public class MyDate {

    private int year;
    private int monnth;
    private int day;

    public MyDate(int year, int monnth, int day) {
        this.year = year;
        this.monnth = monnth;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonnth() {
        return monnth;
    }

    public void setMonnth(int monnth) {
        this.monnth = monnth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(year).append("-").append(monnth).append("-").append(day);
        return stringBuffer.toString();
    }
}
