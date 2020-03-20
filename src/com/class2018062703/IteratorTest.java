package com.class2018062703;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        Iterator iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
        }
//        iterator.hasNext();

        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (i % 2 == 1) {
                iterator.remove();
            }
            i++;
        }


        StringBuffer stringBuffer = new StringBuffer();
        //深度优化的方法想
//        stringBuffer.append();
        //bu能在for
        for (Object o : list) {
            list.remove(o);
        }
    }
}
