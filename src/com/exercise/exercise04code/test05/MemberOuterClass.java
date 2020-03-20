package com.exercise.exercise04code.test05;

public class MemberOuterClass {


    class MemberInnerClass{
        private void init(){
            System.out.println("MemberInnerClass init");
        }
    }

    public static void main(String[] args) {
        MemberOuterClass memberOuterClass = new MemberOuterClass();
        MemberInnerClass memberInnerClass = memberOuterClass.new MemberInnerClass();
        memberInnerClass.init();
    }

}
