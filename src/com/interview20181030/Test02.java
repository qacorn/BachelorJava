package com.interview20181030;

public class Test02 {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        oper(a, b);
        System.out.print(a + "," + b);
    }

    static void oper(StringBuffer c, StringBuffer d) {
        c.append("B");
        d = c;
    }
}
