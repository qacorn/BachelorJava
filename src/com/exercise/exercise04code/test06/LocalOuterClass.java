package com.exercise.exercise04code.test06;

public class LocalOuterClass {

    public void getName(){
        class LocalInnerClass{
            private void init(){
                System.out.println("LocalInnerClass init");
            }
        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.init();
    }

    public static void main(String[] args) {
        LocalOuterClass localOuterClass = new LocalOuterClass();
        localOuterClass.getName();
    }
}
