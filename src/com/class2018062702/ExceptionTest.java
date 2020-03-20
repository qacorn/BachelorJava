package com.class2018062702;

public class ExceptionTest {

    public static int test01(){
        int m = 10;
        try {

            m = m/0;
            System.out.println(m);
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            m = 10;
            return m;
        } finally {
            m = 100;
            System.out.println("finally ");
        }
    }

    public static void main(String[] args) {
//        test01();
        try {
            test03();
        } catch (ApiBDException e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    private static void test03() throws ApiBDException {
        System.out.println(test01());
//        throw  new ApiBDException("40073","wrong password","wrong password",false);
//        throw  new ApiBDException("40073","wrong password","wrong password");
        throw  new ApiBDException("40073","wrong password");
    }

}
