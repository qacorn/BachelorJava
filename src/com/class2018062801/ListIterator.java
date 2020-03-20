package com.class2018062801;

import java.util.ArrayList;
import java.util.List;

public class ListIterator {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Sham");
        names.add("Rajf");
        names.add("afjdak");
        names.add("RKRkk");
        names.add("Ddklkl");

        java.util.ListIterator<String> stringListIterator = names.listIterator();

//        while (stringListIterator.hasNext()){
//            System.out.println(stringListIterator.next());
//        }

        while (stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previous());
        }
    }


}
