package com.class2018070603;

public class Product extends Thread{

    public Product(String name, ProductConsumeTest productConsumeTest) {
        super(name);
        this.productConsumeTest = productConsumeTest;
    }

    private ProductConsumeTest productConsumeTest;

    @Override
    public void run() {
        productConsumeTest.pickApple();
    }
}
