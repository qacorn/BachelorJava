package com.class062201;

public class BullSort {

    public static void main(String[] args) {
        int[] toSortArray = {4,22,8,76,55,100,8,9,21,10};
//        int[] toSortArray2 = {100,76,55,22,21,10,9,8,8,4};
//        int[] toSortArray = {4,8,8,9,10,21,22,55,76,100};
        boolean exchange = false;

//        toSortArray.clone();


        for (int i = 1; i < toSortArray.length; i++) {
            exchange = false;
            for (int j = 0; j < toSortArray.length-i; j++) {
                if (toSortArray[j] < toSortArray[j+1]){
                    int temp = toSortArray[j];
                    toSortArray[j] = toSortArray[j+1];
                    toSortArray[j+1] = temp;
                    exchange = true;
                }
            }

            if (!exchange ){
                for (int k = 0; k < toSortArray.length; k++) {
                    System.out.print(toSortArray[k] + "  ");
                }
                System.out.println();
                System.out.println("排序结束");
                break;
            }

            for (int k = 0; k < toSortArray.length; k++) {
                System.out.print(toSortArray[k] + "  ");
            }
            System.out.println();


            System.out.println("外层循环仍在进行!");
        }


    }






}
