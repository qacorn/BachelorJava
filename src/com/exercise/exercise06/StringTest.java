package com.exercise.exercise06;

public class StringTest {

    public static void mb_operate(String x, String y) {
        x.concat(y);
        y = x;
    }

    public static void main(String args[]) {
        String a = "A";
        String b = "B";
        mb_operate(a, b);
        System.out.println(a + "." + b);
    }


}
