package com.class2018062503;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class A {

    private PrintService printService = PrintService.getInstance();

    public int getNum() {
        return printService.getReadNum(10);
    }

    public void test() {
        String a = PrintService.name;
    }

    public static void test1() throws ClassNotFoundException, NoSuchFieldException {
        //获取指定类型的Class对象
        Class aClass = Class.forName("com.jlq.t20180625.B");
        Class b = B.class;

        B bb = new B();
        Class c = bb.getClass();


        //通过指定类型的Class对象拿到指定类型的构造器，成员属性，方法
        Constructor[] constructors = c.getConstructors();
//        constructors[0].newInstance("kjkf");
        Constructor[] constructors1 = c.getConstructors();
        Method[] methods = c.getMethods();
        try {
            Method method = c.getMethod("getNum", int.class, int.class);
            c.newInstance();
            B bccc = new B();


            //这两种写法等价
            method.invoke(bccc, 12, 10);
            bccc.getNum(12, 10);


        } catch (Exception e) {
            e.printStackTrace();
        }

        Field[] fields = c.getFields();

        Field field = c.getField("aaaa");
    }

    public static void main(String[] args) {

        B b = new B();
        System.out.println(b.getClass().getPackage().getName());;
        System.out.println(b.getClass().getName());

        try {
            Class c = Class.forName("com.jlq.t20180625.B");
            c.getMethod("getNum", int.class).invoke(c.newInstance(), 10);
            B o = (B) c.newInstance();
            Class superclass = c.getSuperclass();
            c.getInterfaces();
            o.getNum(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //实现一个框架
    /**
     * 可以为任意一个类的成员变量赋值
     * 王亚军开发的框架，需要能够为观浩写的类的所有属性赋值，也可以为其他任何人写的类的所有属性赋值
     */
}
