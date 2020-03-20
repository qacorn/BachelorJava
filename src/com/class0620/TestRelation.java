package com.class0620;

public class TestRelation {



    public static  void  main(String[] args){

        boolean a,b,c;
        a = true;
        b = false;
        c = false;

        System.out.println(!a&&b);
        System.out.println(a&&b||c);
        System.out.println(!b||c);


        int testA = 1;
        int testB = 3;

        System.out.println(testA&testB);
        System.out.println(testA|testB);
        System.out.println(~testA);
        System.out.println(testA^testB);


        int testC = 15;

        System.out.println(testC&testB);
        System.out.println(testC|testB);
        System.out.println(~testC);
        System.out.println(testC^testB);
//        3
//        15
//                -16
//        12

        int testD = 3;
        int testE = 4;

        System.out.println(testD&testE);
        System.out.println(testD|testE);
        System.out.println(~testD);
        System.out.println(testD^testE);

        int testF = 5;
        int testG = 5;
        int testH = testF==testG?testF:testD;
        System.out.println(testH);

    }
}
