package com.class2018062602;


import java.io.UnsupportedEncodingException;

public class Test {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();

        a1.test();
        a2.test();


        char[] charArray = {'a','b','c'};

        String s = new String(charArray);
        s = new String(charArray,3,7);
        byte[] bytes = {(byte) 97,(byte) 98,(byte) 99};

        try {
            String sBy = new String(bytes,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
