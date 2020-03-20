package com.class2018062504;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Task {

    public static void main(String[] args) {
        Object[] objects = new Object[10];
        objects[0] = 1;
        objects[1] = "guanhao";
        objects[2] = true;
        objects[3] = new Date();

        Task task = new Task();
        task.reflectionTask("com.class2018062504.TestEntity",objects);


    }

    public void reflectionTask(String className,Object[] args){

        int assignIndex = 0;
        try {
            Class classTask = Class.forName(className);
            Field[] declaredFields = classTask.getDeclaredFields();
            Object object = classTask.newInstance();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                String fieldName = field.getName();
                System.out.println(fieldName);
                Class fieldClass = field.getType();
//                field.getGenericType();


//                System.out.println(fieldClass);
//                System.out.println(field.getGenericType());
//                System.out.println(args[assignIndex].getClass().toString());
//                if (fieldClass == args[assignIndex].getClass()){
//                    System.out.println("akjdlkfla;dfklk");
//                }
//                if (fieldClass.toString().equals(args[assignIndex].getClass().toString())){
                    StringBuffer stringBuffer = new StringBuffer("set");
                    stringBuffer.append(getUpperField(fieldName));
                    Method method = classTask.getMethod(stringBuffer.toString(),fieldClass);
                    method.invoke(object,args[assignIndex]);
                    assignIndex++;


                    StringBuffer stringBufferGet = new StringBuffer();
                    if (fieldClass.toString().equals("boolean")){
                        stringBufferGet.append("is").append(getUpperField(fieldName));
                    }else {
                        stringBufferGet.append("get").append(getUpperField(fieldName));
                    }
                    Method methodGet = classTask.getMethod(stringBufferGet.toString());
                    System.out.println("设置的" + fieldName + "值为:" + methodGet.invoke(object));
//                }else{
//                    break;
//                }

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private String getUpperField(String fieldName){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));
        return stringBuffer.toString();
    }

    private String getPrimaryType(String type){
        if (type.equals("class java.lang.Integer")){
            return "int";
        }

        return "int";
    }

}
