package com.class20180625;

public class PrintService {

    public static  String name = "hp";

    //一旦加载这个类，就会 new 这个类
    private static PrintService printService = new PrintService();

    private PrintService() {
    }

//    public static PrintService getInstance(){
//        return printService;
//    }

    public static PrintService getInstance(){

        return printService;
    }




}
