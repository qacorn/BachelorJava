package com.class2018062505;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Assign {

    public static void assign(String className, Object[] data) {
        try {
            System.out.println("加载" + className);
            Class c = Class.forName(className);

            System.out.println("创建" + className + "实例");
            Object instance = c.newInstance();

            System.out.println("获取" + className + "的属性");
            Field[] fields = c.getDeclaredFields();

            Method[] methods = c.getMethods();
            Map<String, Method> methodName2MethodMap = new HashMap<>(methods.length * 10);

            for (Method method : methods) {
                methodName2MethodMap.put(method.getName(), method);
            }

            for (int i = 0; i < fields.length; i ++) {
                String methodName = getMethodName(fields[i].getName(), "set");
                System.out.println("调用" + methodName);
                Method method = methodName2MethodMap.get(methodName);
                method.invoke(instance, data[i]);
            }

            for (int i = 0; i < fields.length; i ++) {
                String methodName = getMethodName(fields[i].getName(), "get");
                Method method = methodName2MethodMap.get(methodName);
                System.out.println("属性" + fields[i].getName() + ": " + method.invoke(instance));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static String getMethodName(String fieldName, String prefix) {
        return prefix + upperCaseFirstLatter(fieldName);
    }

    private static String upperCaseFirstLatter(String str){
        char[] strChar=str.toCharArray();
        strChar[0] -= 32;
        return String.valueOf(strChar);
    }

    public static void main(String[] args) {
        assign("com.jlq.t20180625.com.class0620.Person", new Person().fetchData());
    }
}
