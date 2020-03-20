package com.class2018062601;

public class Test {

    public static void main(String[] args) {
        Circle c1 = new Circle(1,2,10);
        Circle c2 = new Circle(2,5,10);
        Circle c3 = new Circle(1,2,5);

        //c1 == c2   c1!=c3

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

        String s = "Guanhao";
        System.out.println(s.hashCode());
    }
}
