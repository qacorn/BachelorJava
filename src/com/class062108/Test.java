package com.class062108;

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
        employee.doSome(new CallBackInterface() {
            @Override
            public void tellMe() {
                System.out.println("work done!");
                employee.doSome(new CallBack2() {
                    @Override
                    public void addChopstick() {
                        System.out.println("添加筷子!");
                        employee.doSome(new BringSauce() {
                            @Override
                            public void bringLaoGanMaChiliCrispSauce() {
                                System.out.println("给我拿瓶老干妈!");
                                employee.doSome(new OpenAirControl() {
                                    @Override
                                    public void openAirControl() {
                                        System.out.println("打开空调!");
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });


    }
}
