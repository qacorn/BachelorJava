package com.exercise.exercise06;

public class TestGetChars {
    public static void main(String[] args) {
        String myString = new String("Hello World!");
        char[] yourString = new char[16];
        myString.getChars(6, 11, yourString, 0);
        System.out.println(myString);
        System.out.println(yourString);
    }

}
