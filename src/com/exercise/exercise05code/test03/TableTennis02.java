package com.exercise.exercise05code.test03;

public class TableTennis02 {

    public static void main(String[] args) {
        char i, j, k;
        for (i = 'X'; i <= 'Z'; i++) {
            for (j = 'X'; j <= 'Z'; j++) {
                for (k = 'X'; k <= 'Z'; k++) {
                    if (i != j && i != k && j != k) {
                        if (i != 'X' && k != 'X' && k != 'Z') {
                            System.out.println("A-->" + i);
                            System.out.println("B-->" + j);
                            System.out.println("C-->" + k);
                        }
                    }
                }
            }
        }
    }
}
