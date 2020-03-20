package com.class062401;

import java.lang.reflect.*;

public class Test02 {

    private static final String classPackage = "com.class062401.com.class0620.Person";
    private static final String classPackageSuperMan = "com.class062401.SuperMan";

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.printPackageAndName();

        test02.testMethod();

        test02.testConstructor();

        test02.testField();

        test02.getFieldAndMethodAndInterface();

        try {
            Class class005 = Class.forName(classPackageSuperMan);
            System.out.println("调用无参方法fly():");
            Method fly = class005.getMethod("fly");
            fly.invoke(class005.newInstance());

            Method walk = class005.getMethod("walk", int.class);
            walk.invoke(class005.newInstance(),100);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public void getFieldAndMethodAndInterface() {
        try {
            Class class004 = Class.forName(classPackageSuperMan);
            Class superclass = class004.getSuperclass();
            System.out.println("Super class name:" + superclass.getName());

            Field[] declaredFields = class004.getDeclaredFields();
//            Field[] declaredFields = class004.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println("类中的成员:" + i + ": " + declaredFields[i]);
            }

            Method[] declaredMethods = class004.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                System.out.println("取得SuperMan的方法:" + i + ": ");
                System.out.println("函数名:" + declaredMethods[i].getName());
                System.out.println("函数返回类型:" + declaredMethods[i].getReturnType());
                System.out.println("函数返回类型:" + declaredMethods[i].getParameterTypes());
                System.out.println("函数访问修饰符:" + Modifier.toString(declaredMethods[i].getModifiers()));
                System.out.println("函数代码写法:" + declaredMethods[i]);
            }

            Class[] interfaces = class004.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                System.out.println("实现的接口类:" + interfaces[i].getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void testField() {
        try {
            Class class03 = Class.forName(classPackage);
            Object obj = class03.newInstance();
            Field fieldName = class03.getDeclaredField("name");
            fieldName.setAccessible(true);
            fieldName.set(obj,"小虎");
            System.out.println("修改属性之后得到属性变量的值:" + fieldName.get(obj));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testConstructor() {
        Class class01 = null;
        Person person1 = null;
        Person person2 = null;

        try {
            class01 = Class.forName(classPackage);
            Constructor[] constructors = class01.getConstructors();
            person1 = (Person) constructors[0].newInstance();
            person1.setName("Guanhao");
            person1.setAge(18);

            System.out.println(person1.getName() + "," + person1.getAge());


            person2 = (Person) constructors[1].newInstance(21,"xiaohong");
            System.out.println(person2.getName() + "," + person2.getAge());


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

    public void testMethod() {
        Class class3 = null;

        {
            try {
                class3 = Class.forName("com.class062401.Person");
                Person person = (Person) class3.newInstance();
                person.setName("Guanhao");
                person.setAge(18);

                System.out.println(person.getName() + ", "+person.getAge());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public void printPackageAndName() {
        Class class1 = null;
        Class class2 = null;

        try {
            class1 = Class.forName("com.class062401.Person");
            StringBuffer stringBuffer = new StringBuffer();
            (stringBuffer.append("写法1,包名:").append(class1.getPackage().getName())).append(",完整类名:").append(class1.getName());
            System.out.println(stringBuffer.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("写法1找不到类!");
        }

        class2 = Person.class;

        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("写法2,包名:").append(class2.getPackage().getName()).append(",完整类名:").append(class2.getName());
        System.out.println(stringBuffer2.toString());
    }


}
