package com.class2018102001;

public class BinarySearchSecond {

    public static int getIndex(int[] array, int value) {
        int max = array.length - 1;
        int min = 0;
        int mid = (max + min)/2;

        while (value != array[mid]) {

            if (array[mid] > value) {
                max = mid - 1;
            } else if (array[mid] < value) {
                min = min + 1;
            }
            if (min > max) {
                return -1;
            }
            mid = (max + min)/2;
        }
        return mid;
    }

}
