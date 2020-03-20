package com.class062401;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Task {

    public static void main(String[] args) {

        Task task = new Task();
        Object[] objects = new Object[10];
        objects[0] = 1;
        objects[1] = "guanhao";
        objects[2] = new Date();

        task.reflectionTask("com.class062401.com.class0620.Person","name","Guanhao");
        task.reflectionTask("com.class062401.SuperMan","blueBriefs",true);

    }

//    public void reflectionTask(String className,Object[] args){
//        try {
//            Class classTask = Class.forName(className);
//            Method[] declaredMethods = classTask.getDeclaredMethods();
//
//            for (int i = 0; i < declaredMethods.length; i++) {
//                Method method = declaredMethods[i];
//                if (method.getName().startsWith("set")){
//                    method.invoke()
//                }
//            }
//
//            for (int i = 0; i < declaredFields.length; i++) {
//                declaredFields[i].getName();
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void reflectionTask(String className,String fieldName,Object value){
        try {
            Class classTask = Class.forName(className);
            StringBuffer stringBuffer = new StringBuffer("set");
            stringBuffer.append(getUpperField(fieldName));
            Field field = classTask.getDeclaredField(fieldName);
            Class<?> fieldType = field.getType();
            Method method = classTask.getMethod(stringBuffer.toString(),fieldType);
            Object object = classTask.newInstance();
            method.invoke(object,value);

//            field.setAccessible(true);
//            System.out.println("设置的属性值为:" + field.get(object));

            StringBuffer stringBufferGet = new StringBuffer();
            if (fieldType.toString().equals("boolean")){
                stringBufferGet.append("is").append(getUpperField(fieldName));
            }else {
                stringBufferGet.append("get").append(getUpperField(fieldName));
            }
            Method methodGet = classTask.getMethod(stringBufferGet.toString());
            System.out.println("设置的" + fieldName + "值为:" + methodGet.invoke(object));



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("未找到该属性!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private String getUpperField(String fieldName){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));
        return stringBuffer.toString();
    }

}
