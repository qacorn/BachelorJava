package com.class2018062801;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String,String>  map = new HashMap<>();

        map.put("a","wangyahun");
        map.put("b","haimian");
        map.put("b","haimian2");


//        Map<String,String>  map2 = new HashMap<>();
//
//        map.put("a","wangyahun2");
//        map.put("b","haimian");
//
//
//        map.putAll(map2);
//
//        System.out.println(map.get("a"));
//        System.out.println(map.get("b"));


        Set<String> stringSet = map.keySet();

        for (String key:stringSet) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        System.out.println("-----------华丽丽的分割线----------------");

        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()){
            System.out.println(map.get(iterator.next()));
        }

        System.out.println("-----------华丽丽的分割线2----------------");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry: entries){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("-----------华丽丽的分割线3----------------");

        Iterator<Map.Entry<String, String>> iteratorEntry = entries.iterator();
        while (iteratorEntry.hasNext()){
            Map.Entry<String, String> next = iteratorEntry.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }

        System.out.println("-----------华丽丽的分割线4----------------");

    }
}
