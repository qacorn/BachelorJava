package com.class062201;

public class ArrayOrde {


    public static void main(String[] args) {

        int[] toSortArray = {4,22,8,76,55,100,8,9,21,10};


        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < toSortArray.length; i++) {
            if (toSortArray[i] > max) {
                max = toSortArray[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        int[] newToSortArray = new int[toSortArray.length-1];
        for (int j = 0; j < newToSortArray.length; j++) {
//            newToSortArray[j] = toSortArray[]
        }


    }
}
