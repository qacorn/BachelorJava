package com.exercise.exercise05code.test03;

public class TableTennis01 {

    private String A,B,C;

    public TableTennis01(String a, String b, String c) {
        A = a;
        B = b;
        C = c;
    }

    public static void main(String[] args) {
        String[] strings = {"X","Y","Z"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    TableTennis01 tableTennis = new TableTennis01(strings[i],strings[j],strings[k]);
                    if (!tableTennis.A.equals(tableTennis.B)&&!tableTennis.A.equals(tableTennis.C)&&!tableTennis.B.equals(tableTennis.C)){
                        if(!tableTennis.A.equals("X")&&!tableTennis.C.equals("X")&&!tableTennis.C.equals("Z")){
                            System.out.println("A-->" + tableTennis.A);
                            System.out.println("B-->" + tableTennis.B);
                            System.out.println("C-->" + tableTennis.C);
                        }
                    }
                }
            }
        }
    }
}
