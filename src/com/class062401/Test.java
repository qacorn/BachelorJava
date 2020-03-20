package com.class062401;

public class Test {

    public static void main(String[] args) {
    Person person = new Person();
        System.out.println("package name:" + person.getClass().getPackage().getName());
        System.out.println("full class name:" + person.getClass().getName());


        try {
            Class c = Class.forName("com.class062401.Person");
            Person person1 = (Person) c.newInstance();
            c.getSuperclass();
            c.getInterfaces();
            person1.setAge(20);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }



}
