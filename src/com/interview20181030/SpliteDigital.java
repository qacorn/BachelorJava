package com.interview20181030;

public class SpliteDigital {
//
//    个位(数) = units (digit)
//    十位(数) = tens (digit)
//    百位(数) = hundreds (digit)
//    千位(数) = thousands (digit)
//    万位(数) = ten thousands (digit)
//    十万位(数) = hundred thousands (digit)

    public static void main(String[] args) {
//        int a = 2345;
//        int unitsDigit = a%10;
//        int tensDigit = a%100/10;
//        int hundredsDigit = a%1000/100;
//        int thousandDigit = a%10000/1000;
//        System.out.println(unitsDigit);
//        System.out.println(tensDigit);
//        System.out.println(hundredsDigit);
//        System.out.println(thousandDigit);

        int test = 987654321;
        getSingleDigit(test);

    }

    public static void getSingleDigit(int demo) {
        int uintDigit = demo%10;
        int tensDigit = demo/10%10;
        int hundredDigit = demo/100%10;
        int thousandDigit = demo/1000%10;

        for (int i = 0; i < 10; i++) {
            System.out.println((int)(demo/Math.pow(10,i))%10);
        }


    }
}
