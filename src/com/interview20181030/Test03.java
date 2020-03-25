package com.interview20181030;

public class Test03 {

    public static void T3()
    {
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        switchStr(a, b);
        System.out.println(a+","+b);
    }

    public static void switchStr(StringBuffer x,StringBuffer y)
    {
        x.append(y);
        System.out.println(x);
        y=x;
        System.out.println(y);
    }
}
