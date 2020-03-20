package com.class0618.haimian2;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        if (verifyAge(age)){
            this.age = age;
        }else{
            System.out.println("Person构造错误!");
        }
    }

    private boolean verifyAge(int age){
        return !(age>150);
    }

    public void setAge(int age) {
        this.age = age;
    }
}
