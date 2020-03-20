package com.class2018070501;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();
        Thread thread = new Thread(testRunnable);
        Thread thread001 = new Thread(new TestRunnable(),"甲");
        thread.start();
        thread001.start();
    }


}
