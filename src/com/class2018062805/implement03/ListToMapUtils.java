package com.class2018062805.implement03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMapUtils {

    public interface AssignKeyAndValue<T, K, V> {
        K getKey(T t);

        V getValue(T t);
    }

    public interface GroupListByKeyword<T, K> {
        K getKeyword(T t);
    }

    public static <T, K, V> Map<K, V> changeListToMap(List<T> changeList, AssignKeyAndValue<T, K, V> assignKeyAndValue) throws DuplicatedKeyException {
        Map<K, V> kToVMap = new HashMap<>();
        for (int i = 0; i < changeList.size(); i++) {
            if (kToVMap.containsKey(assignKeyAndValue.getKey(changeList.get(i)))) {
                throw new DuplicatedKeyException("40037", "DuplicatedKey");
            } else {
                kToVMap.put(assignKeyAndValue.getKey(changeList.get(i)), assignKeyAndValue.getValue(changeList.get(i)));
            }
        }
        return kToVMap;
    }

    public static <T, K> Map<K, List<T>> groupList(List<T> groupList, GroupListByKeyword<T, K> groupListByKeyword) {
        Map<K, List<T>> kToListMap = new HashMap<>();
        for (int i = 0; i < groupList.size(); i++) {
            T toBeGroup = groupList.get(i);
            K keyword = groupListByKeyword.getKeyword(toBeGroup);
            if (i == 0 || !(kToListMap.containsKey(keyword))) {
                List<T> groupOne = new ArrayList<>();
                groupOne.add(toBeGroup);
                kToListMap.put(keyword, groupOne);
            } else if (kToListMap.containsKey(keyword)) {
                kToListMap.get(keyword).add(toBeGroup);
            }
        }
        return kToListMap;
    }

}
