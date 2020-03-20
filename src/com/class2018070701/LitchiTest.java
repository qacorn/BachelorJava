package com.class2018070701;

public class LitchiTest {

    public static void main(String[] args) {
        LitchiWarehouse litchiWarehouse = new LitchiWarehouse();
        PickThread pickThread1 = new PickThread("高州生产基地",litchiWarehouse);
        PickThread pickThread2 = new PickThread("梅州生产基地",litchiWarehouse);
        PickThread pickThread3 = new PickThread("惠州生产基地",litchiWarehouse);
        SellThread sellThread1 = new SellThread("深圳销售中心",litchiWarehouse);
        SellThread sellThread2 = new SellThread("广州销售中心",litchiWarehouse);
        SellThread sellThread3 = new SellThread("北京销售中心",litchiWarehouse);
        pickThread1.start();
//        pickThread2.start();
//        pickThread3.start();
        sellThread1.start();
//        sellThread2.start();
//        sellThread3.start();
    }


    //完成销售额用时:300649
}
