package com.exercise.exercise02;

public class Person {

    private int id;
    private String name;
    private int age;
    private String address;

    public String getName(int id) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id为").append(id).append("的Person姓名为").append(name).append(",年龄为").append(age).append(",住址为").append(address).append(".");
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public void setName(int id,String name,int age,String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }


}
