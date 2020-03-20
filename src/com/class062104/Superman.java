package com.class062104;

public class Superman implements ISuperman {


    public void fight() {
        System.out.println("会武功");
    }

    public void fly() {
        System.out.println("会飞");
    }

    public void swim() {
        System.out.println("会游泳");
    }

    public static void main(String[] args) {
        Superman superman = new Superman();
        superman.fight();
        superman.fly();
        superman.swim();
    }
}
