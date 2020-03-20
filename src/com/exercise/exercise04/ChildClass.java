package com.exercise.exercise04;

public class ChildClass extends FatherClass {

    public ChildClass() {
        System.out.println("ChildClass Create");
    }


    public static void main(String[] args) {
        FatherClass fc = new FatherClass();
        ChildClass cc = new ChildClass();
    }

}
