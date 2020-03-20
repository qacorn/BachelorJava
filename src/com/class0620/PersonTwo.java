package com.class0620;

public class PersonTwo {

    private int age = 18;

    private String name = "John";

    static {
        System.out.println("Hello,Wangyajin");
    }

    {
        System.out.println("Hello,Guanhao");
    }




    public PersonTwo() {
        System.out.println("Hello,com.class0620.PersonTwo");
    }

    public PersonTwo(int age, String name) {
        System.out.println("Hello,com.class0620.PersonTwo");
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        PersonTwo personTwo = new PersonTwo();
    }
}
