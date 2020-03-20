package com.class2018070807;

public class PickThread extends Thread {

    private LitchiWarehouse litchiWarehouse;

    public PickThread(String name, LitchiWarehouse litchiWarehouse) {
        super(name);
        this.litchiWarehouse = litchiWarehouse;
    }

    @Override
    public void run() {
            litchiWarehouse.pickLitchi();
    }
}
