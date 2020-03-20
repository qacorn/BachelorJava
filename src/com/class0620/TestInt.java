package com.class0620;

public class TestInt {

    //akk;a;fd

    public int getInt(){
        return 1;
    }

    /**
     * Java Main Function
     * mgakl
     *
     *
     */
    public static void main(String[] args){
        TestInt testInt = new TestInt();
        System.out.println(testInt.getInt());

        short abc = 200;

        byte bTemp = (byte) abc;

        System.out.println(bTemp);


        String a = "35";
        String b = "20";
        String c = a+b;
        String d = a + b;
        Integer e = Integer.valueOf(a)+Integer.valueOf(b);
        System.out.println(c);
        //System.out.println(d);
        System.out.println("a+b=" + e);

        int testA = 15;
        int testB = 3;
        int testC = 2;
        int testD = 7;
        int testE = 5;


        System.out.println(testA/testB);
        System.out.println(testC*testD);
        System.out.println(testB+testE);


        int testAA = 0;

        int testBB = testInt.addOne(testAA);

        testBB = testBB++;
        System.out.println(testBB);//0




    }

    public int addOne(int a){
        return  a++;
    }


}
