package com.class2018062804;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();


//        personList.add(new com.class0620.Person(10,"eanjyajun"));
//        personList.add(new com.class0620.Person(11,"yuncin"));
//        personList.add(new com.class0620.Person(12,"guanhai"));
//        personList.add(new com.class0620.Person(14,"liqinaia"));

        Map<Integer,Person.Info>   id2PersonMap = new HashMap<>(personList.size() *10);

        for (int i = 0; i < personList.size(); i++) {
            id2PersonMap.put(personList.get(i).getInfo().getId(),personList.get(i).getInfo());
        }





    }
}
