package com.class2018070701;

public class LitchiWarehouse {

    private int currentLitchi = 0;
    private int stock = 5;
    private int salesAmount = 100;
    private int currentSale = 0;
    private long startTime = 0;
    private long endTime = 0;

    private Object stockLock = new Object();
//    private Object salesLock = new Object();

    public void pickLitchi() {
        if (currentSale == 0) {
            startTime = System.currentTimeMillis();
        }
        try {
            synchronized (stockLock) {
                while (currentSale < salesAmount) {
                    if (currentLitchi < stock) {
                        System.out.println(Thread.currentThread().getName() + " 摘取荔枝");
                        Thread.sleep(2000L);
                        currentLitchi++;
                        System.out.println("当前荔枝库存为:" + currentLitchi + ",当前销售额为:" + currentSale);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " 发现仓库已满,暂停摘取荔枝");
                        stockLock.notify();
                        stockLock.wait();
                    }
                }
            }
            System.out.println("达到销售额，停止摘取");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sellLitchi() {
        try {
            synchronized (stockLock) {
                while (currentSale < salesAmount) {
                    if (currentLitchi > 0) {
                        System.out.println(Thread.currentThread().getName() + " 销售荔枝");
                        Thread.sleep(4000L);
                        currentLitchi--;
                        currentSale++;
                        System.out.println("当前荔枝库存为:" + currentLitchi + ",当前销售额为:" + currentSale);
                    } else if (currentLitchi == 0) {
                        System.out.println(Thread.currentThread().getName() + " 发现仓库已空,暂停销售荔枝");
                        stockLock.notify();
                        stockLock.wait();
                    }
                }
                stockLock.notify();
                System.out.println("达到销售额，停止销售");
                endTime = System.currentTimeMillis();
                System.out.println("完成销售额用时:" + (endTime - startTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


