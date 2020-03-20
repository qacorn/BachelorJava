package com.class2018070605;

public class Consumer extends Thread{
    private int dailyMaxConsume = 10;
    private int currentConsume = 0;
    private Stock stock;

    public Consumer(String name, Stock stock) {
        super(name);
        this.stock = stock;
    }

    public void consume() throws InterruptedException {
        if (stock.checkStockForConsume()) {
            stock.prepareConsume();
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
