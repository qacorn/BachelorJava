package com.class2018070605;

public class Test {

    public static void main(String[] args) {
        Stock stock = new Stock(8);
        Producer producer1 = new Producer("生产者1",stock);
        Producer producer2 = new Producer("生产者2",stock);
        Producer producer3 = new Producer("生产者3",stock);
        Consumer consumer1 = new Consumer("消费者1",stock);
        Consumer consumer2 = new Consumer("消费者2",stock);
        Consumer consumer3 = new Consumer("消费者3",stock);
//        producer.produce();
//        consumer.consume();
        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
