package com.class2018070603;

public class Consume extends Thread {


    private ProductConsumeTest productConsumeTest;

    public Consume(String name, ProductConsumeTest productConsumeTest) {
        super(name);
        this.productConsumeTest = productConsumeTest;
    }

    @Override
    public void run() {
        productConsumeTest.eatApple2();
    }
}
