package com.class062107;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    static class StringCompator<String> implements Comparator<String>{

        public int compare(String o1, String o2) {
            return -1;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Wang");
        list.add("Ya");
        list.add("Jun");
        list.add("Teacher");
        list.sort(new StringCompator<String>());


        //1.8才支持
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
    }

}
