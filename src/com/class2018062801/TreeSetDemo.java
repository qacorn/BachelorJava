package com.class2018062801;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        set.add("f");
        set.add("z");
        set.add("A");
        set.add("y");

        System.out.println(set.size());
        System.out.println(set.first());
        System.out.println(set.last());

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
