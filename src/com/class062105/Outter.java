package com.class062105;

public class Outter {

    public static void main(String[] args) {
        Inner i = new Inner();
        Inner i2 = new Inner();
        i.init();
    }

    static class Inner{
        public void init(){
            System.out.println("这里是静态内部类!");
        }
    }
}
