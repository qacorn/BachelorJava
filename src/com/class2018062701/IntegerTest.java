package com.class2018062701;

public class IntegerTest {

    public static void main(String[] args) {
        System.out.println("@基本数据类型与封装类型比较@");
        int i = 200;
        Integer i2 = 200;
        Integer i3 = new Integer(200);
        // Integer会自动拆箱为int，所以为true
        System.out.println(i == i2);
        System.out.println(i == i3);
        System.out.println("@封装类型在位于-128到127之间的比较@");
        Integer iii5 = 127;
        Integer iii6 = 127;
        System.out.println(iii5 == iii6);// true
        //java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);

        System.out.println("@封装类型不在-128到127之间的比较@");
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);// false
        //以上要查看Integer的源码部分分析

        System.out.println("@封装类型采用new运算符之后的比较@");
        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); // false

        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8); // false


        Integer ii10 = new Integer(10);
        Integer ii11 = new Integer(10);
        System.out.println(ii10 == ii11);
    }
}
