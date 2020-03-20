package com.class2018070806;

public class SellThread extends Thread {

    private LitchiWarehouse litchiWarehouse;

    public SellThread(String name, LitchiWarehouse litchiWarehouse) {
        super(name);
        this.litchiWarehouse = litchiWarehouse;
    }

    @Override
    public void run() {
            litchiWarehouse.sellLitchi();
    }
}
