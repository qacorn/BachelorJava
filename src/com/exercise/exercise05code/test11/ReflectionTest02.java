package com.exercise.exercise05code.test11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest02 {

    public static void main(String[] args) {
        try {
            Class class002 = Class.forName("com.exercise.exercise05code.test11.Demo");
            Method[] declaredMethods = class002.getDeclaredMethods();
            Object object = class002.newInstance();

//            for (int i = 0; i < declaredMethods.length; i++) {
//                Method method = declaredMethods[i];
//                System.out.println(method.getName());
//            }
//            declaredMethods[0].invoke(object);
//            declaredMethods[1].invoke(object,"guanhao");


            Method method1 = class002.getMethod("method1");
            method1.invoke(object);
            Method method2 = class002.getMethod("method2",String.class);
            method2.invoke(object,"Guanhao");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
