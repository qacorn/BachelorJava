package com.class2018070601;

public class RunnableA implements Runnable {

    private int i = 0;

    public synchronized void test(){
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打印" + i);
        }
    }

    @Override
    public void run() {
        test();
    }
}
