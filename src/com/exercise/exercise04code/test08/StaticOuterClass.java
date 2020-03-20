package com.exercise.exercise04code.test08;

public class StaticOuterClass {

    static class StaticInnerClass{
        private void init(){
            System.out.println("StaticInnerClass init");
        }
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.init();
    }
}
