package com.class062103;

public class Bird implements IRunner {
    public void start() {
        System.out.println("蹬腿、跳");
    }

    public void run() {
        System.out.println("摆动翅膀  Bird 飞起来   " );
    }

    public void stop() {
        System.out.println("停止摆动翅膀  Bird 停下来   " );
    }

    public void fly(){
        System.out.println("fly@@@@@@@");
    }
}
