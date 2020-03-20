package com.class2018070810;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LitchiWarehouse {
    private int maxStock = 5;
    private final int salesAmount = 30;

    private BlockingQueue<Litchi> litchiBlockingQueue = new ArrayBlockingQueue<>(maxStock);


    private long startTime = 0;
    private long endTime = 0;

    public void pickLitchi() {

        startTime = System.currentTimeMillis();
        int putCount = 0;
        try {
            while (putCount< salesAmount){
                System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 开始摘取荔枝......");
                Litchi litchi = new Litchi(0,LitchiStatus.PREPARE_PICK);
                litchiBlockingQueue.put(litchi);
                Thread.sleep(2000L);
                putCount++;
                System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 完成摘取荔枝......");
//                litchi.setLitchiStatus(LitchiStatus.PICK_COMPLETE);
                litchi.setLitchiStatus(LitchiStatus.ADDED_TO_STOCK);
                System.out.println("已生产的荔枝为:" +putCount);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sellLitchi() {
        int takeCount= 0;
        try {
            while (takeCount <= salesAmount) {
                System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 正在销售荔枝......");
                Thread.sleep(2000L);
                litchiBlockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 荔枝出库......");
                takeCount++;
                System.out.println( "当前销售额为:" + takeCount);
                if (takeCount == salesAmount) {
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "发现达到销售额，停止销售");
                    System.out.println("完成销售额用时:" + (endTime - startTime));
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
