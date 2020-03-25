package com.class2018092610Singleton;

public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton() {

    }
//第一种：饿汉式在类创建的同时就实例化一个静态对象出来，不管之后会不会使用这个单例，都会占据一定的内存，但是相应的，在第一次调用时速度也会更快，因为其资源已经初始化完成，
    public static LazySingleton getInstance() {
        if (null == lazySingleton) {
            return lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
