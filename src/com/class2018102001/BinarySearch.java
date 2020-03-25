package com.class2018102001;

public class BinarySearch {

    private static int[] searchArray = {11, 22, 33, 55, 77, 99, 112, 1214, 1234, 3456, 4567, 5678, 6789, 7890};

    private static int target = 5678;

    public static int binarySearch(int index) {
//        int midIndex = searchArray.length/2;
        if (target == searchArray[index]) {
            return searchArray[index];
        } else if (target > searchArray[index]) {
            index = (index + searchArray.length) / 2;
            return binarySearch(index);
        } else {
            index = index / 2;
            return binarySearch(index);
        }
    }

    public static void main(String[] args) {

//        binarySearch(searchArray.length/2);
        int index = BinarySearchSecond.getIndex(searchArray, target);
        System.out.println(index);
    }



}
