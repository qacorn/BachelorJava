package com.class2018070802;

import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable{

    // consumed计数器允许线程停止
    AtomicInteger consumed = new AtomicInteger();

    @Override
    public void run() {

    }
//
//    public void consume() {
//        if (!items.isEmpty()) {
//            System.out.println("Consuming " + items.pop());
//            consumed.incrementAndGet();
//        }
//    }
//
//    private boolean theEnd() {
//        return consumed.get() >= NO_ITEMS;
//    }
//
//    @Override
//    public void run() {
//        while (!theEnd()) {
//            synchronized (items) {
//                while (items.isEmpty() && (!theEnd())) {
//                    try {
//                        items.wait(10);
//                    } catch (InterruptedException e) {
//                        Thread.interrupted();
//                    }
//                }
//                consume();
//            }
//        }
//    }
}
