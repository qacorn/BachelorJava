package com.class2018070602;

public class PrintTest {

    public static void main(String[] args) {
        PrintTask printTask =  new PrintTask();
        Thread thread01 = new Thread(printTask);
        Thread thread02 = new Thread(printTask);
        thread01.start();
        thread02.start();
    }
}
