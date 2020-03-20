package com.class2018070804;

public class LitchiTest {

    public static void main(String[] args) {
        LitchiWarehouse litchiWarehouse = new LitchiWarehouse();
        PickThread pickThread1 = new PickThread("广州生产基地",litchiWarehouse);
        PickThread pickThread2 = new PickThread("惠州生产基地",litchiWarehouse);
        PickThread pickThread3 = new PickThread("高州生产基地",litchiWarehouse);
        SellThread sellThread1 = new SellThread("北京销售中心",litchiWarehouse);
        SellThread sellThread2 = new SellThread("南京销售中心",litchiWarehouse);
        SellThread sellThread3 = new SellThread("天津销售中心",litchiWarehouse);
        pickThread1.start();
        pickThread2.start();
        pickThread3.start();
        sellThread1.start();
        sellThread2.start();
        sellThread3.start();
    }


    //完成销售额用时:300649
//    使用三个锁
    //完成销售额用时:202782
//三个生产者 三个消费者
//    完成销售额用时:70264
//    当前荔枝库存为:5,当前销售额为:51
}
