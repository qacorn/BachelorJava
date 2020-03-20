package com.class2018070604;

public class Consumer extends Thread{
    private int dailyMaxConsume = 40;
    private int currentConsume = 0;
    private Stock stock;

    public Consumer(Stock stock) {
        this.stock = stock;
    }

    public void consume() throws InterruptedException {
        if (stock.checkStockForConsume()) {
            Thread.sleep(3000L);
            stock.minusStock();
            currentConsume ++;
        } else {
            try {
                synchronized (stock.consumeStock) {
                    stock.consumeStock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            while (currentConsume < dailyMaxConsume) {
                consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
