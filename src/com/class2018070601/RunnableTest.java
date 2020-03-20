package com.class2018070601;

public class RunnableTest {

    public static void main(String[] args) {
        RunnableA runnableA1 = new RunnableA();
        RunnableA runnableA2 = new RunnableA();
        Thread thread1 = new Thread(runnableA1);
        Thread thread2 = new Thread(runnableA1);

        thread1.start();
        thread2.start();
    }

}
