package com.class2018092605.wang1;

public class Implement05 {

    private static volatile Implement05 implement05;

    public Implement05() {
    }

    //懒汉形式（延迟加载）
    //这个是标准的单例模式，通过newInstance里面的判断来进行延迟加载单例对象，这里加了synchronized关键字可以避免多线程问题，但会影响程序性能。

    public  static Implement05 getInstance(){
        synchronized (Implement05.class) {
            if (implement05 == null) {
                implement05 = new Implement05();
            }
        }
        return implement05;
    }
}
