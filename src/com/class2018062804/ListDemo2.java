package com.class2018062804;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {

    public static void main(String[] args) {

        List<B> bList = new ArrayList<>();

        List<A> aList = new ArrayList<>();

        test(bList);

        test(aList);

    }

//    public static void test(List<?> list){
//        for (Object o : list) {
//            System.out.println(o);
//        }
//    }

    public static void test(List<? extends B> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
