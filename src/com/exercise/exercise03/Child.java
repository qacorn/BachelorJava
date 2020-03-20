package com.exercise.exercise03;

public class Child extends Parent{

    void printMe() {
        System.out.println("child");
    }
    void printAll() {
        super.printMe();
        this.printMe();
        printMe();
    }

}
