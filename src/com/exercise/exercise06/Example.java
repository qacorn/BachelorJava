package com.exercise.exercise06;

import java.util.Arrays;

public class Example {

    String str=new String("hello");
    char ch[]={'d','b','c'};
    public static void main(String args[]){
        Example ex=new Example();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str+ "-------------");
        System.out.println(ex.str+" and "+ex.ch[0]);
    }
    public void change(String str,char ch[]){
        System.out.println(str+ "-------------");
//        str="world";ch[0]= 'a';
        this.str="world";ch[0]= 'a';
        System.out.println(str+ "-------------");



    }

}
