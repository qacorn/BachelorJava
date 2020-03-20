package com.exercise.exercise02;

public class Animal {
    private String name;
    private int legs;

    public Animal() {
        name = "AAA";
        legs = 4;
    }


    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    public void move(){
        System.out.println(name + " Moving!!");
    }

    public void move(int moveNumber){
        for (int i = 0; i < moveNumber; i++) {
            System.out.println(name + " Moving!!");
        }
    }
}
