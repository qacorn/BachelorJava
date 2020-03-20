package com.class0620;

public class Person {

    String name;


    public static void main(String[] args){


        Integer i1 = 100;
        Integer i2 = 100;

        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2);
        System.out.println(i3==i4);

        Double d1 = 100d;
        Double d2 = 100d;

        Double d3 = 200d;
        Double d4 = 200d;

        System.out.println(i1==i2);
        System.out.println(i3==i4);


        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;

        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        int m =1;
        long n = 2;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));//
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
        System.out.println(g.equals(m+n));

//        true
//        false
//        true
//        true
//        true
//        false
//        true
//        true
    }


}
