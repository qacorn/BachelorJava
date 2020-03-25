package com.interview20181030;

import java.util.LinkedList;

public class Test08 {

    static LinkedList reverseLinkedList(LinkedList linkedList) {
        LinkedList<Object> newLinkedList = new LinkedList<>();
        for (Object object : linkedList) {
            newLinkedList.add(0, object);
        }
        for (int i = 0; i < linkedList.size(); i++) {
            newLinkedList.add(linkedList.get(i));
        }
        return newLinkedList;
    }

}
