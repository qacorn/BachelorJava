package com.class2018070806;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LitchiWarehouse {

    private int maxStock = 5;
    private final int salesAmount = 30;

    private int litchiInProduceNumber = 0;
    private Object litchiInProduceLock = new Object();

    private int currentLitchi = 0;
    private Object currentLitchiLock = new Object();

    private int currentProduce = 0;
    private Object currentProduceLock = new Object();
    boolean produceComplete = false;

    private int litchiInSaleNumber = 0;
    private Object litchiInSaleLock = new Object();

    private int currentSales = 0;
    private Object currentSalesLock = new Object();
    boolean salesComplete = false;


    private Object pickLock = new Object();
    private Object sellLock = new Object();

    private long startTime = 0;
    private long endTime = 0;


    public void pickLitchi() {
        if (currentSales == 0) {
            startTime = System.currentTimeMillis();
        }
        try {
            while (!produceComplete) {
                boolean fullStock = false;
                int rediusStock = 0;
                synchronized (currentLitchiLock) {
                    rediusStock = maxStock - currentLitchi;
                }

                synchronized (litchiInProduceLock) {
                    //生产中的荔枝个数 》= 剩余库存，说明库存满了。
                    fullStock = litchiInProduceNumber >= rediusStock;
                }

                if (!fullStock) {
                    int residualProduceAmount = 0;
                    synchronized (currentProduceLock) {
                        if (currentProduce == salesAmount){
                            break;
                        }else if (currentProduce > salesAmount){
                            break;
                        }else if (currentProduce < salesAmount){
                            residualProduceAmount = salesAmount - currentProduce;
                        }
                    }
                    synchronized (litchiInProduceLock) {
                        litchiInProduceNumber++;
//                        System.out.println("正在生产的荔枝为:" + litchiInProduceNumber );
                        if (residualProduceAmount == litchiInProduceNumber){
                            produceComplete = true;
                            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "发现刚好生产达到销售额，开始摘取");
                        }else if (residualProduceAmount < litchiInProduceNumber){
                            produceComplete = true;
                            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "发现生产达到销售额，停止摘取");
                            break;
                        }else{
                            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 开始摘取荔枝......");
                        }
                    }

                    Thread.sleep(2000L);
                    //希望这三部操作要同时被执行
                    synchronized (currentLitchiLock) {
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 完成摘取荔枝......");
                        currentLitchi++;
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 完成荔枝入库......");
                        System.out.println("当前荔枝库存为:" + currentLitchi);
                    }

                    synchronized (litchiInProduceLock){
                        litchiInProduceNumber --;
                        System.out.println("正在生产的荔枝为:" + litchiInProduceNumber);
                    }
                    synchronized (currentProduceLock){
                        currentProduce++;
                        System.out.println("已生产的荔枝为:" + currentProduce);
                    }

                    //
                    synchronized (sellLock) {
                        sellLock.notify();
                    }
                } else {
                        System.out.println("当前荔枝库存为:" + currentLitchi + "正在生产的荔枝为:" + litchiInProduceNumber );
                    synchronized (pickLock) {
                        //如果仓库已满，打印荔枝库存 正在生产的荔枝
                        System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())+" 发现仓库已满,暂停摘取荔枝");
                        pickLock.wait();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "发现生产达到销售额，停止摘取");
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
                    haveLitchi = (currentLitchi > 0);
                }
                if (haveLitchi) {
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 正在销售荔枝......");
                    Thread.sleep(4000L);
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 找到买家");
                    int residualSalesAmount = 0;
                    synchronized (currentSalesLock){
                        if (currentSales > salesAmount){
                            break;
                        }else if (currentSales == salesAmount){
                            break;
                        }else if (currentSales < salesAmount){
                            residualSalesAmount = salesAmount - currentSales;
                        }
                    }



                    synchronized (litchiInSaleLock){
                        litchiInSaleNumber++;


                    }
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


