package com.class2018070604;

public class Producer extends Thread{
    private Stock stock;

    public Producer(Stock stock) {
        this.stock = stock;
    }

    public void produce() throws InterruptedException {
        if (stock.checkStockForProduce()) {
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
            while (true) {
                produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
