package com.class2018071103.utils;

import java.util.List;

public class ListUtils {
    public static Boolean isNotEmpty(List list) {
        return list != null && list.size() > 0;
    }

    public static Boolean isEmpty(List list) {
        return !isNotEmpty(list);
    }
}
