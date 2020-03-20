package com.class2018070810;

public class LitchiTest {

    public static void main(String[] args) {
        LitchiWarehouse litchiWarehouse = new LitchiWarehouse();
        PickThread pickThread1 = new PickThread("广州生产基地",litchiWarehouse);
        PickThread pickThread2 = new PickThread("惠州生产基地",litchiWarehouse);
        PickThread pickThread3 = new PickThread("高州生产基地",litchiWarehouse);
        PickThread pickThread4 = new PickThread("增城生产基地",litchiWarehouse);
        PickThread pickThread5 = new PickThread("湛江生产基地",litchiWarehouse);
        PickThread pickThread6 = new PickThread("梅州生产基地",litchiWarehouse);
        PickThread pickThread7 = new PickThread("桂林生产基地",litchiWarehouse);

        SellThread sellThread1 = new SellThread("北京销售中心",litchiWarehouse);
        SellThread sellThread2 = new SellThread("南京销售中心",litchiWarehouse);
        SellThread sellThread3 = new SellThread("天津销售中心",litchiWarehouse);
        SellThread sellThread4 = new SellThread("济南销售中心",litchiWarehouse);
        SellThread sellThread5 = new SellThread("太原销售中心",litchiWarehouse);
        SellThread sellThread6 = new SellThread("西安销售中心",litchiWarehouse);
        SellThread sellThread7 = new SellThread("洛阳销售中心",litchiWarehouse);
        SellThread sellThread8 = new SellThread("开封销售中心",litchiWarehouse);
        SellThread sellThread9 = new SellThread("兰州销售中心",litchiWarehouse);
        SellThread sellThread10 = new SellThread("武汉销售中心",litchiWarehouse);
        SellThread sellThread11 = new SellThread("成都销售中心",litchiWarehouse);
        SellThread sellThread12 = new SellThread("上海销售中心",litchiWarehouse);
        SellThread sellThread13 = new SellThread("杭州销售中心",litchiWarehouse);
        SellThread sellThread14 = new SellThread("宁波销售中心",litchiWarehouse);
        SellThread sellThread15 = new SellThread("苏州销售中心",litchiWarehouse);
        SellThread sellThread16 = new SellThread("南昌销售中心",litchiWarehouse);
        SellThread sellThread17 = new SellThread("长沙销售中心",litchiWarehouse);
        SellThread sellThread18 = new SellThread("重庆销售中心",litchiWarehouse);

        pickThread1.start();
        pickThread2.start();
        pickThread3.start();
//        pickThread4.start();
//        pickThread5.start();
//        pickThread6.start();
//        pickThread7.start();

        sellThread1.start();
        sellThread2.start();
        sellThread3.start();
        sellThread4.start();
        sellThread5.start();
        sellThread6.start();
//        sellThread7.start();
//        sellThread8.start();
//        sellThread9.start();
//        sellThread10.start();
//        sellThread11.start();
//        sellThread12.start();
//        sellThread13.start();
//        sellThread14.start();
//        sellThread15.start();
//        sellThread16.start();
//        sellThread17.start();
//        sellThread18.start();
    }
}
