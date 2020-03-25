package com.class2018092610Singleton;

public class EagerSingleton {

    //变量会在任何方法被调用之前得到初始化
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("EagerSingleton()");
    }

    public static EagerSingleton getInstance() {
        System.out.println("getInstance()");
        return eagerSingleton;
    }
}
