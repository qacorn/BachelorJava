package com.exercise.exercise06;

public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer buf1 = new StringBuffer(20);
        System.out.println(buf1.length() + "," + buf1.capacity());

//        String s= "ABCD";
//        s.concat("E");
//        s.replace('C','F');
//
//        System.out.println(s);
//
//        System.out.println(s.replace('C','F'));


//        String s = "home directory";
//        String t = s - "directory";


        String[] s2 = new String[10];

        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
        System.out.println(s2.length);


//        String s = "你好";
//        int i = 3;
//        s += i;
//        System.out.println(s);


//        String s = "你好";
//        int i = 3;
//        if (i == s) {
//            s += i
//        } ;

//        String s = "你好";
//        int i = 3;
//        s = i +;


        String s=null;
        int i=(s!=null)&&(s.length()>0)?s.length():0;
        System.out.println(i);


    }
}
