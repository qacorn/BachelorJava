package com.class2018070802;

public class Producer implements Runnable {
    @Override
    public void run() {

    }

//    public void produce(int i) {
//        System.out.println("Producing " + i);
//        items.push(new Integer(i));
//    }
//
//    @Override
//    public void run() {
//        int i = 0;
//        // 生产10次
//        while (i++ < NO_ITEMS) {
//            synchronized (items) {
//                produce(i);
//                items.notifyAll();
//            }
//            try {
//                // 休眠一段时间
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
}
