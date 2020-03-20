package com.class2018070605;

public class Stock {
    private int currentStock;
    private int numberInProduce = 0;
    private int numberInConsume = 0;
    private int maxStock;
    private final Object currentStockLock = new Object();

    public final Object produceStock = new Object();
    public final Object consumeStock = new Object();


    public Stock(int maxStock) {
        this.maxStock = maxStock;
    }

    public boolean checkStockForProduce() {
        synchronized (currentStockLock) {
            if (currentStock + numberInProduce < maxStock) {
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
            System.out.println(Thread.currentThread().getName() + "生产，当前库存" + currentStock);
        }
        synchronized (consumeStock) {
            consumeStock.notifyAll();
        }
    }

    public void minusStock() {
        synchronized (currentStockLock) {
            currentStock --;

            System.out.println(Thread.currentThread().getName()+ "消费，当前库存" + currentStock);
        }
        synchronized (produceStock) {
            produceStock.notifyAll();
        }
    }

    public void prepareProduce(){
        numberInProduce++;
    }

    public void prepareConsume(){
        numberInConsume ++;
    }

}
