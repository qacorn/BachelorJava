package com.singleton;

public class Implement06 {

    private Implement06() {
    }

    private static Implement06 implement06;

    public Implement06 implement06(){
        if (null == implement06) {
            implement06 = new Implement06();
        }
        return implement06;
    }
}
