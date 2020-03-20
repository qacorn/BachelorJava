package com.class2018062504;

import java.util.Date;

public class TestEntity {

    private int age;
    private String name;
    private boolean marry;
    private Date  marryDate;


    public TestEntity() {
    }

    public TestEntity(int age, String name, Date marryDate) {
        this.age = age;
        this.name = name;
        this.marryDate = marryDate;
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

    public boolean isMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }

    public Date getMarryDate() {
        return marryDate;
    }

    public void setMarryDate(Date marryDate) {
        this.marryDate = marryDate;
    }
}
