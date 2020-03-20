package com.class2018070603;

import java.util.ArrayList;
import java.util.List;

public class ProductConsumeTest {

    private int productDay = 0;

    private List<Apple> appleList = new ArrayList<>(1);

    private Object listLock = new Object();

    public void pickApple() {
        try {
            while (productDay <10) {
                synchronized (listLock) {
                    if (appleList.size() == 0) {
                        System.out.println(Thread.currentThread().getName() + "生产1个苹果");
                        Apple apple = new Apple();
                        appleList.add(apple);
                        listLock.notify();
                        listLock.wait();
                    }
//                    else if (appleList.size() > 0) {
//                        System.out.println(Thread.currentThread().getName() + "篮子已满");
//                        listLock.wait();
//                    }
                }
                productDay ++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void eatApple() {

        try {
            while (productDay <= 10) {
                synchronized (listLock) {
//                    if (appleList.size() == 0) {
//                        System.out.println(Thread.currentThread().getName() + "没有苹果，等待生产者生产!");
//                        listLock.wait();
//                    } else
                        if (appleList.size() > 0){
                            appleList.remove(0);
                            System.out.println(Thread.currentThread().getName() + "拿到苹果");
                            listLock.notify();
                            listLock.wait();
//                        if (productDay == 10){
//                            System.out.println("订单生产完成!");
//                            listLock.notify();
//                            break;
//                        }else {
//                            listLock.notify();
//                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public void eatApple2() {

        try {
            while (productDay <= 10) {
                synchronized (listLock) {
//                    if (appleList.size() == 0) {
//                        System.out.println(Thread.currentThread().getName() + "没有苹果，等待生产者生产!");
//                        listLock.wait();
//                    } else
                    if (appleList.size() > 0){
                        appleList.remove(0);
                        System.out.println(Thread.currentThread().getName() + "拿到苹果并吃掉");
                        listLock.notify();
                        listLock.wait();
//                        if (productDay == 10){
//                            System.out.println("订单生产完成!");
//                            listLock.notify();
//                            break;
//                        }else {
//                            listLock.notify();
//                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
