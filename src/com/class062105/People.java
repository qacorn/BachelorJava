package com.class062105;

public class People {

    public static void main(final String[] args) {
        class Woman extends People{
            int age = 3;
            public void getAge(){
                System.out.println("age=" + age);
            }
        }
        Woman woman = new Woman();
        woman.getAge();
    }
}
