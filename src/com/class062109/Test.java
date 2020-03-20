package com.class062109;

public class Test {

    public static void main(String[] args) {


//        Employee employee = new Employee();
//        Boss boss = new Boss();
//        employee.doSome(boss.tellMe());
//        boss.tellMe();

//        Employee employee = new Employee();
//        Boss boss = new Boss();
//        employee.doSome(boss.tellMe());
//        boss.tellMe();


//        Employee employee = new Employee();
//        Boss boss = new Boss();
//        employee.doSome(boss);

        Employee employee = new Employee();

//        employee.doSome(new CallBackInterface() {
//            @Override
//            public void tellMe() {
//                System.out.println("work done!");
//            }
//        }, new CallBack2() {
//            @Override
//            public void addChopstick() {
//
//            }
//        });
        CallBackInterface callBackInterface = new Boss();
        CallBack2 callBack2 = new Boss();

//        employee.doSome(new CallBackInterface() {
//            @Override
//            public void tellMe(CallBack2 callBack2) {
//                System.out.println("work done!");
//            }
//        }, new CallBack2() {
//            @Override
//            public void addChopstick() {
//                System.out.println("添加筷子!");
//            }
//        });

        employee.doSome(callBackInterface,callBack2);


    }
}
