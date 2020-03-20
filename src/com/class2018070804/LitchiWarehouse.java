package com.class2018070804;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LitchiWarehouse {

    private int currentLitchi = 0;
    private int maxStock = 5;
    private int salesAmount = 50;
    private int currentSales = 0;
    private long startTime = 0;
    private long endTime = 0;

    private Object pickLock = new Object();
    private Object sellLock = new Object();
    private Object currentLitchiLock = new Object();
    private Object currentSalesLock = new Object();
    boolean salesComplete = false;

    public boolean checkStockForProducer() {
        synchronized (currentLitchiLock) {
            return currentLitchi < maxStock;
        }
    }

    public boolean checkStockForConsumer() {
        synchronized (currentLitchiLock) {
            return currentLitchi > 0;
        }
    }


    public void pickLitchi() {
        if (currentSales == 0) {
            startTime = System.currentTimeMillis();
        }
        try {
            synchronized (currentSalesLock) {
                salesComplete = currentSales >= salesAmount;
            }
            while (!salesComplete) {
//                boolean fullStock = false;
//                synchronized (currentLitchiLock) {
//                    fullStock = currentLitchi < maxStock;
//                }
                if (checkStockForProducer()) {
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 开始摘取荔枝......");
                    Thread.sleep(2000L);
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 完成摘取荔枝......");
                    synchronized (currentLitchiLock) {
                        currentLitchi++;
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 完成荔枝入库......");
                        System.out.println("当前荔枝库存为:" + currentLitchi + ",当前销售额为:" + currentSales);
                    }
                    synchronized (sellLock) {
                        sellLock.notify();
                    }
                } else {
                    synchronized (pickLock) {
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())+" 发现仓库已满,暂停摘取荔枝");
                        pickLock.wait();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "发现达到销售额，停止摘取");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sellLitchi() {
        try {
            synchronized (currentSalesLock) {
                salesComplete = currentSales > salesAmount;
            }
            while (!salesComplete) {
                boolean haveLitchi = false;
                synchronized (currentLitchiLock) {
                    haveLitchi = currentLitchi > 0;
                }
                if (haveLitchi) {
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 正在销售荔枝......");
                    Thread.sleep(4000L);
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 找到买家");
                    synchronized (currentLitchiLock) {
                        currentLitchi--;
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 荔枝出库......");
                        System.out.println("当前荔枝库存为:" + currentLitchi + ",当前销售额为:" + currentSales);
                    }
                    synchronized (pickLock) {
                        pickLock.notify();
                    }
                    synchronized (currentSalesLock) {
                        currentSales++;
                        if (currentSales == salesAmount) {
                            salesComplete = true;
                            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "发现达到销售额，停止销售");
                            endTime = System.currentTimeMillis();
                            System.out.println("完成销售额用时:" + (endTime - startTime));
                        } else {
//                            sellLock.wait();
                        }
                    }
                } else {
                    synchronized (sellLock) {
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 发现仓库已空,暂停销售荔枝");
                        sellLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


