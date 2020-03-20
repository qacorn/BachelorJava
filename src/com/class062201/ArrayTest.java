package com.class062201;

import java.util.Date;

public class ArrayTest {

    public static void main(String[] args) {
        String[]  testArray = new String[5];
        System.out.println(testArray.length);

        System.out.println(testArray[0]);

        int[] m = new int[45];
        System.out.println(m[0]);


        Date[] dateArray = new Date[5];


        dateArray[0] = new Date();
        dateArray[1] = new Date();

        //wrong
        Date date = new Date();
        dateArray[0] = date;
        dateArray[1] = date;


        String string = new String();
        System.out.println("string==" + string + "string");
        System.out.println("-----------");




    }
}
