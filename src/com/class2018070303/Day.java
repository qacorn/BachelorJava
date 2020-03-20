package com.class2018070303;

public class Day {

    private Day() {}

    public static final Day MONDAY;
    public static final Day TUESDAY;
    public static final Day WENESDAY;

    static {
        MONDAY = new Day();
        TUESDAY = new Day();
        WENESDAY = new Day();
    }
}
