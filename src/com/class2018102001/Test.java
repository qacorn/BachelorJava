package com.class2018102001;

public class Test {

    public static void main(String[] args) {
        int[] idArary = {1, 5, 3, 8, 9, 10, 123, 78, 99, 45, 67};
//        SortUtility.insertionSort(idArary);
//        SortUtility.insertSortSecond(idArary);
        SortUtility.binarySearchInsertSort(idArary);
        for (int i = 0; i < idArary.length; i++) {
            System.out.println(idArary[i]);
        }
    }
}
