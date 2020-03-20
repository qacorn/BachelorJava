package com.class2018070605;

public class Producer extends Thread{
    private Stock stock;
    private int orderNumber = 20;
    private int currentNumber = 0;
    private int numberInProduce = 0;

    public Producer(String name, Stock stock) {
        super(name);
        this.stock = stock;
    }

    public void produce() throws InterruptedException {
        if (stock.checkStockForProduce()) {
            stock.prepareProduce();
            Thread.sleep(2000);
            stock.addStock();
        } else {
            try {
                synchronized (stock.produceStock) {
                    stock.produceStock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            while (currentNumber < orderNumber) {
                produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
