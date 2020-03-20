package com.class2018070503;

public class TestMain {

    public synchronized void a(){
        try {
            Thread.sleep(2000L);
            System.out.println("执行 a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void b(){
        try {
            Thread.sleep(2000L);
            System.out.println("执行 b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void a1(){
        System.out.println("执行 a1");
    }

    public void b1(){
        System.out.println("执行 b1");
    }
}
