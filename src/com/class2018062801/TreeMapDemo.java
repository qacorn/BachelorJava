package com.class2018062801;

import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<Code,Person> map = new TreeMap<>();

        Person person01 = new Person(new Code(1111),"张三");
        Person person02 = new Person(new Code(1112),"李四");
        Person person03 = new Person(new Code(1113),"王五");
        Person person04 = new Person(new Code(1114),"赵柳");
        Person person05 = new Person(new Code(1115),"周其");

        map.put(person01.getCode(),person01);
        map.put(person02.getCode(),person02);
        map.put(person03.getCode(),person03);
        map.put(person04.getCode(),person04);
        map.put(person05.getCode(),person05);

        System.out.println(map.size());

        Set<Map.Entry<Code, Person>> entries = map.entrySet();

        Iterator<Map.Entry<Code, Person>> iterator = entries.iterator();

        while (iterator.hasNext()){
            Map.Entry<Code, Person> next = iterator.next();
            Person value = next.getValue();
            System.out.println(value.getCode().getId() + " ||" + value.getName());
        }

        Person person = map.get(new Code(1111));
        System.out.println(person);


//        //两个都写，以比较器为准
//        TreeMap<Code,com.class0620.Person> map2 = new TreeMap<>(new Comparator<Code>() {
//            @Override
//            public int compare(Code o1, Code o2) {
//                return 0;
//            }
//        });

    }
}
