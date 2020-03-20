package com.exercise.exercise05code.test02;

public class ArrayTest02 {

    /**
     *
     * 2. 将一个整型数组的所有元素相加，输出和，并输出最大值和最小值
     * @param args
     */

    public static void main(String[] args) {
        int[] arr={1,13,45,5,0,0,16,6,0,25,4,17,6,7,0,15};

        int sum = 0;
        int min = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max){
                max = arr[i];
            }

            if (arr[i] < min){
                min = arr[1];
            }
        }

        System.out.println("数组各元素的和为:" + sum);
        System.out.println("数组最大值:" + max);
        System.out.println("数组最小值:" + min);

    }
}
