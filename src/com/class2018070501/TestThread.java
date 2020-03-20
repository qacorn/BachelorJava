package com.class2018070501;

public class TestThread extends Thread{


    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println(getName() + " is running" + i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread1 = new TestThread("thread1");
        TestThread testThread2 = new TestThread("thread2");
        testThread1.start();
        testThread2.start();
    }
}
