package com.class2018062801;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetDemo {




    public static void main(String[] args) {
        Set<String>  set = new HashSet<>();
        set.add("one");
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");

        System.out.println(set.size());

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Set<String> setString = new LinkedHashSet<>();
        setString.add("one");
        setString.add("one");
        setString.add("two");
        setString.add("three");
        setString.add("four");

        System.out.println(setString.size());

        Iterator<String> iterator1 = setString.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}
