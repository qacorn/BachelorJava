package com.class2018070702;

public class LitchiWarehouse {

    private int currentLitchi = 0;
    private int stock = 5;
    private int salesAmount = 50;
    private int currentSale = 0;
    private long startTime = 0;
    private long endTime = 0;

    private Object pickLock = new Object();
    private Object sellLock = new Object();

    public void pickLitchi() {
        if (currentSale == 0) {
            startTime = System.currentTimeMillis();
        }
        try {
            while (currentSale < salesAmount) {

                if (currentLitchi < stock) {
                    System.out.println(Thread.currentThread().getName() + " 摘取荔枝");
                    Thread.sleep(2000L);
                    synchronized (pickLock) {
                        currentLitchi++;
                        System.out.println("当前荔枝库存为:" + currentLitchi + ",当前销售额为:" + currentSale);
//                        sellLock.wait();
                    }
                }
                if (currentLitchi == stock) {
                    System.out.println(Thread.currentThread().getName() + " 发现仓库已满,暂停摘取荔枝");
                }
            }

            System.out.println("达到销售额，停止摘取");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sellLitchi() {
        try {

            while (currentSale < salesAmount) {
                if (currentLitchi > 0) {
                    System.out.println(Thread.currentThread().getName() + " 销售荔枝");
                    Thread.sleep(4000L);
                    synchronized (sellLock) {
                        currentLitchi--;
                        sellLock.notify();
                        currentSale++;
                        System.out.println("当前荔枝库存为:" + currentLitchi + ",当前销售额为:" + currentSale);
                        if (currentSale == salesAmount) {
                            System.out.println("达到销售额，停止销售");
                            endTime = System.currentTimeMillis();
                            System.out.println("完成销售额用时:" + (endTime - startTime));
                        } else {
                            sellLock.wait();
                        }
                    }
                }
                if (currentLitchi == 0) {
                    System.out.println(Thread.currentThread().getName() + " 发现仓库已空,暂停销售荔枝");
//                    sellLock.wait();
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


