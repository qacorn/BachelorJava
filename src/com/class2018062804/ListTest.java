package com.class2018062804;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {


        List<String> stringList = new ArrayList<>();
        stringList.add("2345");

        List<?> list = new ArrayList<>();

//        list.add(22);
//        list.add("223");

        List<?> listA = new ArrayList<String>();
//        listA.add("aigdjfo")

        list = stringList;
        System.out.println(list.get(0));
    }
}
