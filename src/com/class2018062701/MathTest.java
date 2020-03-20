package com.class2018062701;

public class MathTest {

    public static void main(String[] args) {

        //floor  向下取整
        System.out.println(Math.floor(-12.6f));//-13.0

        System.out.println(Math.floor(12.6f));//12.0

        //ceil  向上取整
        System.out.println(Math.ceil(-12.6));//-12.0

        System.out.println(Math.ceil(12.6f));//13.0

        System.out.println(Math.floor(-12.3f));//-13.0

        System.out.println(Math.floor(12.3f));//12.0

        System.out.println(Math.ceil(-12.3));//-12.0

        System.out.println(Math.ceil(12.3f));//13.0

        System.out.println("---------华丽丽的分割线--------");

        System.out.println((int)12.3f);//12
        System.out.println((int)-12.3f);//12


        Math.random();



    }
}
