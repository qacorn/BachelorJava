package com.singleton;

public class Implement01 {

    private Implement01() {
    }

    //饿汉形式（贪婪加载）
    //在单例对象声明的时候就直接初始化对象，可以避免多线程问题，但是如果对象初始化比较复杂，会导致程序初始化缓慢。
    private static Implement01 implement01 = new Implement01();
    private static String name = "Feng_zhuling";

    public static Implement01 getInstance(){
        return implement01;
    }

}
