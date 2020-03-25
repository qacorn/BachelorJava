package com.class2018102001;

public class SortUtility {

    public static void insertionSort(int[] argument) {
        for (int i = 1; i < argument.length; i++) {

            int insertIndex = 0;
//            int temp = argument[i];
            for (int j = i - 1; j >= 0; j--) {
                if (argument[j] < argument[i]) {
                    insertIndex = j+1;
                    break;
                }
            }
            int temp = argument[i];
            for (int k = i; k > insertIndex; k--) {
                argument[k] = argument[k - 1];
            }
            argument[insertIndex] = temp;
        }
    }

    public static void insertSortSecond(int[] argument) {
        int elementTobeSort;
        int j;
        for (int i = 1; i < argument.length; i++) {
            elementTobeSort = argument[i];
            for (j = i-1; j >=0 && argument[j] > elementTobeSort; j--) {
                argument[j+1] = argument[j];
            }
            argument[j+1] = elementTobeSort;
        }

    }

    public static void binarySearchInsertSort(int[] toSortArray) {
        int toSortInt;
        for (int i = 1; i < toSortArray.length; i++) {
            toSortInt = toSortArray[i];

            int minIndex = 1;
            int maxIndex = i-1;
            int insertIndex = (minIndex + maxIndex)/2;

            while (minIndex < maxIndex) {
                if (toSortArray[insertIndex] > toSortArray[i]) {
                    maxIndex = maxIndex - 1;
                }
                if (toSortArray[insertIndex] < toSortArray[i]) {
                    minIndex = insertIndex + 1;
                }
                insertIndex = (minIndex + maxIndex)/2;
            }
            int j;
            for (j = i-1; j >= insertIndex; j--) {
                toSortArray[j + 1] = toSortArray[j];
            }
            toSortArray[j+1] = toSortInt;
        }
    }

    public static void binarySearchInsertSortOpt(int[] toSortArray) {
        int toSortInt;
        for (int i = 1; i < toSortArray.length; i++) {
            toSortInt = toSortArray[i];

            int minIndex = 1;
            int maxIndex = i-1;
            int insertIndex = (minIndex + maxIndex)/2;

            while (minIndex < maxIndex) {
                insertIndex = (minIndex + maxIndex)/2;
                if (toSortArray[insertIndex] < toSortArray[i]) {
                    minIndex = insertIndex + 1;
                }else{
                    maxIndex = maxIndex - 1;
                }
            }
            int j;
            for (j = i-1; j >= insertIndex; j--) {
                toSortArray[j + 1] = toSortArray[j];
            }
            toSortArray[j+1] = toSortInt;
        }
    }

    public static void bubbleSort(int[] toSortArray) {
        for (int i = 1; i <= toSortArray.length; i++) {
            boolean exchange = false;
            for (int j = 0; j < toSortArray.length - i; j++) {
                if (toSortArray[j] > toSortArray[j + 1]) {
                    int temp = toSortArray[j + 1];
                    toSortArray[j + 1] = toSortArray[j];
                    toSortArray[j] = temp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }

    public static int bianarySearch(int[] array,int target) {
        int minIndex = 0;
        int maxIndex = array.length -1;
        int middle = array.length/2;
        for (int i = 0; i < array.length; i++) {
            if (target == array[maxIndex]) {
                return middle;
            }
            if (target > array[middle]) {
                minIndex = middle+1;
            }
            if (target < array[middle]) {
                maxIndex = middle -1;
            }
            if (minIndex > maxIndex) {
                break;
            }
            middle = (minIndex + maxIndex)/2;

        }
        return 0;
    }


}
