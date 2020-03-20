package com.class062103;

public class TestDemo {
    public static void test(IRunner runner) {
        runner.start();
        runner.run();
        runner.stop();

        if(runner instanceof  Person){
            ((Person) runner).swim();
        }else if(runner instanceof Bird){
            ((Bird) runner).fly();
        }
    }

    public static void main(String[] args) {
        test(new Person());
        test(new Car());
        test(new Bird());
    }
}
