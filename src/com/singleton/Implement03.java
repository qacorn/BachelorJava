package com.singleton;

public class Implement03 {

    private Implement03() {
    }

    private static Implement03 implement03;

    public Implement03 implement03(){
        //内存中会存在少量Implement03 对象
        implement03 = new Implement03();
        return implement03;
    }
}
