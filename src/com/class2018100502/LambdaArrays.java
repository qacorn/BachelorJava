package com.class2018100502;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaArrays {
    public static void main(String[] args) {
        String[] array = new String[]{"java", "fkava", "fkit", "ios", "android"};
        Arrays.parallelSort(array,((o1, o2) -> o1.length() - o2.length()));
        Arrays.parallelSort(array,(Comparator.comparingInt(String::length)));
        System.out.println(Arrays.toString(array));


    }
}
