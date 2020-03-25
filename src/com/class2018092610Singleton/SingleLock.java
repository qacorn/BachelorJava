package com.class2018092610Singleton;

public class SingleLock {

    private static SingleLock singleLock;

    private SingleLock(){

    }
//懒汉形式（延迟加载）
    //这个是标准的单例模式，通过newInstance里面的判断来进行延迟加载单例对象，这里加了synchronized关键字可以避免多线程问题，但会影响程序性能。

    public synchronized static SingleLock getInstance() {
        if (singleLock == null) {
            singleLock = new SingleLock();
        }
        return singleLock;
    }


}
