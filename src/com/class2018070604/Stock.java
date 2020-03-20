package com.class2018070604;

public class Stock {
    private int currentStock;
    private final Object currentStockLock = new Object();

    public final Object produceStock = new Object();
    public final Object consumeStock = new Object();

    private int maxStock;

    public Stock(int maxStock) {
        this.maxStock = maxStock;
    }

    public boolean checkStockForProduce() {
        synchronized (currentStockLock) {
            if (currentStock < maxStock) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkStockForConsume() {
        synchronized (currentStockLock) {
            if (currentStock > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void addStock() {
        synchronized (currentStockLock) {
            currentStock ++;
            System.out.println("生产者生产，当前库存" + currentStock);
        }
        synchronized (consumeStock) {
            consumeStock.notifyAll();
        }
    }

    public void minusStock() {
        synchronized (currentStockLock) {
            currentStock --;
            System.out.println("消费者消费，当前库存" + currentStock);
        }
        synchronized (produceStock) {
            produceStock.notifyAll();
        }
    }

}
