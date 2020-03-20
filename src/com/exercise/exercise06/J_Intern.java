package com.exercise.exercise06;

public class J_Intern {

    public static void main(String args[]) {
        String s1 = "123456";
        String s2 = "123456";
        String s3 = "123" + "456";
        String a0 = "123";
        String s4 = a0 + "456";
        String s5 = new String("123456");
        String s6 = s5.intern();
        System.out.println("s2" + ((s2 == s1) ? "==" : "!=") + "s1");//==
        System.out.println("s3" + ((s3 == s1) ? "==" : "!=") + "s1");//!=
        System.out.println("s4" + ((s4 == s1) ? "==" : "!=") + "s1");//!=
        System.out.println("s5" + ((s5 == s1) ? "==" : "!=") + "s1");//!=
        System.out.println("s6" + ((s6 == s1) ? "==" : "!=") + "s1");//==
    }

}
