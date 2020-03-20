package com.class2018070604;

public class Test {

    public static void main(String[] args) {
        Stock stock = new Stock(4);
        Producer producer = new Producer(stock);
        Consumer consumer = new Consumer(stock);
//        producer.produce();
//        consumer.consume();
        producer.start();
        consumer.start();
    }
}
