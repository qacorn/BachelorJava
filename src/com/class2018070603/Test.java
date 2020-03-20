package com.class2018070603;

public class Test {

    public static void main(String[] args) {
        ProductConsumeTest productConsumeTest = new ProductConsumeTest();
        Product product = new Product("生产者",productConsumeTest);
        Consume consume = new Consume("消费者",productConsumeTest);
        product.start();
        consume.start();
    }
}
