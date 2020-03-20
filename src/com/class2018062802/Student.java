package com.class2018062802;

public class Student implements Comparable<Student> {

    private int height;

    public Student(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
