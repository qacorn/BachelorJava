package com.exercise.exercise04code.test07;

public class MainActivity {

    public static void main(String[] args) {
        OnBatteryQuery onBatteryQuery = new OnBatteryQuery() {
            @Override
            public void init() {
                System.out.println("当前电量为50%");
            }
        };
        onBatteryQuery.init();

    }

}
