package com.class2018062805.implement02;

import com.class2018062805.User;

import java.util.*;

public class ListToMap<K,V> {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        User user001 = new User(001,"WangYajun");
        User user002 = new User(002,"ChangYunxin");
        User user003 = new User(003,"GuanHao");
        User user004 = new User(004,"LiQianqian");

        userList.add(user001);
        userList.add(user002);
        userList.add(user003);
        userList.add(user004);

        Map<Integer,User> map  = new ListToMap().changeListToMap(userList, new AssignKeyAndValue<Integer,User>() {
            @Override
            public Integer getKey(User o) {
                return o.getUserId();
            }
        });

        Iterator<Map.Entry<Integer, User>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, User> next = iterator.next();
            System.out.println("Map's Key==" + next.getKey());
            System.out.println("Map's Value  " +next.getValue());
        }

    }

    public  Map<K,V>  changeListToMap(List<V> changeList,AssignKeyAndValue<K,V> assignKeyAndValue){
        Map<K,V> kToVMap = new HashMap<>();
        for (int i = 0; i < changeList.size(); i++) {
            kToVMap.put(assignKeyAndValue.getKey(changeList.get(i)),changeList.get(i));
        }
        return kToVMap;
    }
}
