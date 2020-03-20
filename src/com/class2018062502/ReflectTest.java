package com.class2018062502;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {
        try {
            Class aclass = Class.forName("com.class2018062502.B");



//            Class b = B.class;


            Class intC = int.class;

//
            B bb = new B();
            Class c = bb.getClass();
            Class superclass = c.getSuperclass();
            Object cast = c.cast(bb);


            Constructor[] constructors = c.getConstructors();

            c.getConstructors();
            Method[] methods = c.getMethods();
            Field[] fields = c.getFields();



            try {
                Method getNum = c.getMethod("getNum");

                Method getNum1 = c.getMethod("getNum", int.class, int.class);

                try {
                    Object o = constructors[0].newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                try {
                    getNum1.invoke(c.newInstance(),12,10);
//                    bb.getNum()
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                c.getField("getNum");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }





    }


}
