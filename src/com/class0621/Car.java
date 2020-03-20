package com.class0621;

public class Car {

    public Engine engine;

    public InterfaceB interfaceB = new Demo();

    public  void test(){
        interfaceB.getAge();
        //面向接口开发的思想，不能调用接口以外的方法
    }

    public static void main(String[] args) {
        System.out.println(new Demo() instanceof  InterfaceB);
    }
}
