package com.class062103;

public class Person implements  IRunner,ISwimmer{


    public void swim() {
        System.out.println("游泳！！！！！！！");
    }


    public void start() {
        System.out.println("弯腰、蹬腿");

    }


    public void run() {
        System.out.println("摆动手臂 person 跑起来   " );

    }


    public void stop() {
        System.out.println("person 减速直到停止");

    }


    public void eat(){
        System.out.println("吃饭@@@@@@");
    }
}
