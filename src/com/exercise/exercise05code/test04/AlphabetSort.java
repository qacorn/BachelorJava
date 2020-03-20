package com.exercise.exercise05code.test04;

public class AlphabetSort {

    public static void main(String[] args) {
        String[] a={"b","c","d","e","a"};

        boolean exchange = false;

        for (int i = 1; i < a.length; i++) {
            exchange = false;
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].toCharArray()[0] > a[j+1].toCharArray()[0]){
                    String temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    exchange = true;
                }
            }

            if (!exchange){
                break;
            }

            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + "  ");
            }
            System.out.println();

        }

    }

}
