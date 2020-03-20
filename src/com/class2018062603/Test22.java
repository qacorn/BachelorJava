package com.class2018062603;

public class Test22 {

    public static void main(String args[]) {
        int i;
        float f = 2.3f;
        double d = 2.7;
        i = ((int) Math.ceil(f)) * ((int) Math.round(d));
        System.out.println(i);


        System.out.println(Math.ceil(-4.4d));

        StringBuffer buf = new StringBuffer("Beijing2008");
        buf.insert(7, "@");
        System.out.println(buf.toString());

    }


}
