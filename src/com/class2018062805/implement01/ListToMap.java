package com.class2018062805.implement01;


import com.class2018062805.User;

import java.util.*;

public class ListToMap<T, K, V> {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        User user001 = new User(001, "WangYajun");
        User user002 = new User(002, "ChangYunxin");
        User user003 = new User(003, "GuanHao");
        User user004 = new User(004, "LiQianqian");

        userList.add(user001);
        userList.add(user002);
        userList.add(user003);
        userList.add(user004);

        Map<Integer, User> map = new ListToMap().changeListToMap(userList, new AssignKeyAndValue<User, Integer, User>() {
            @Override
            public Integer getKey(User user) {
                return user.getUserId();
            }

            @Override
            public User getValue(User user) {
                return user;
            }
        });

        Iterator<Map.Entry<Integer, User>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, User> next = iterator.next();
            System.out.println("Map's Key==" + next.getKey());
            System.out.println("Map's Value  " + next.getValue());
        }

    }

    public Map<K, V> changeListToMap(List<T> changeList, AssignKeyAndValue<T, K, V> assignKeyAndValue) {
        Map<K, V> kToVMap = new HashMap<>();
        for (int i = 0; i < changeList.size(); i++) {
            kToVMap.put(assignKeyAndValue.getKey(changeList.get(i)), assignKeyAndValue.getValue(changeList.get(i)));
        }
        return kToVMap;
    }
}
