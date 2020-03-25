package com.class2018100501;

public class CommandTest {

    public static void main(String[] args) {
        ProcessArray processArray = new ProcessArray();
        int[] target = {3, -4, 5, 9, 8};
        processArray.process(target, new Command() {
            @Override
            public void process(int[] target) {
                int sum = 0;
                for (int i : target) {
                    sum += i;
                }
            }
        });

        processArray.process(target, target1 -> {
            int sum = 0;
            for (int i : target1) {
                sum += i;
            }
        });

    }
}
