package com.class2018102001;

public class BullSortTest {


    public static void main(String[] args) {
        int[] targetArray = {1, 4, 6, 19, 45, 78, 23, 12};
        BullSort.bullSort(targetArray);
        for (int i = 0; i < targetArray.length; i++) {
            System.out.println(targetArray[i]);
        }
    }

}
