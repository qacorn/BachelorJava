package com.class2018102001;

public class BullSort {


    public static void bullSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean exchange = false;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }
}
