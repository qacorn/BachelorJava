package com.exercise.exercise06;

public class TestStringContructor {

    public static void main(String[] args) {
        byte[] b = {49, 50, 51, 52, 53};
        String myString = new String(b);
        System.out.println(myString);
    }

}
