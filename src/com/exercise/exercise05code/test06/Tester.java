package com.exercise.exercise05code.test06;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {

    public int test(int p1,Integer p2){
        System.out.println("test call !");
        return p1+p2;
    }

    public static void main(String[] args) {

//        optionA();

        optionC();

    }

    private static void optionA() {
        //java.lang.NoSuchMethodException: com.exercise.exercise05code.test06.Tester.test(int, int)
        //	at java.lang.Class.getMethod(Class.java:1786)
        //	at com.exercise.exercise05code.test06.Tester.main(Tester.java:16)
        try {
            Class classType=Tester.class;
            Object tester=classType.newInstance();
            Method addMethod=classType.getMethod("test",new Class[]{int.class,int.class});
            Object result=addMethod.invoke(tester,new Object[]{new Integer(100),new Integer(200)});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void optionB() {
//        try {
//            Class classType=Tester.class;
//            Object tester=classType.newInstance();
//            Method addMethod=classType.getMethod("test",new Class[]{int.class,int.class});
//            int result=addMethod.invoke(tester,new Object[]{new Integer(100),new Integer(200)});
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
    }

    private static void optionC() {
        try {
            Class classType=Tester.class;
            Object tester=classType.newInstance();
            Method addMethod=classType.getMethod("test",new Class[]{int.class,Integer.class});
            Object result=addMethod.invoke(tester,new Object[]{new Integer(100),new Integer(200)});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

//    private static void optionD() {
//        try {
//            Class classType=Tester.class;
//            Object tester=classType.newInstance();
//            Method addMethod=classType.getMethod("test",new Class[]{int.class,Integer.class});
//            Integer result=addMethod.invoke(tester,new Object[]{new Integer(100),new Integer(200)});
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }
}
