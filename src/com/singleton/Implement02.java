package com.singleton;

public class Implement02 {

    private Implement02() {
    }

    private static Implement02 implement02;

    public Implement02 getInstance(){
        //内存中每new一次就会多一个Implement02对象
        return new Implement02();
    }

}
