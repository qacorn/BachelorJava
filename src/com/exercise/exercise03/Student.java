package com.exercise.exercise03;

public class Student extends Teacher{

    float m = 3.0f;
    String n = "Good";

    void print() {
        super.print();
        System.out.println("Class B: m="+m +",n="+n);
    }

}
