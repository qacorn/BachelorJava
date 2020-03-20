package com.class0620;

public class Demo {

    /**
     * 可变参数
     * @param args
     */
    public void print(String... args) {
        System.out.print("可变参数方法执行@@@@@@@@@@:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]+"  ");
        }
    }

    /**
     * 固定参数
     * @param test
     */
    public void print(String arg,String ...favs) {
        System.out.println("固定参数方法执行@@@@@-"+arg);
    }

    public static void main(String[] args) {
        Demo test = new Demo();

//        Integer age = 18;
//        age += 2;
//        age.
//        test.print("hello"); //语法错误
//        test.print("hello", "alexia");//语法错误
    }
}
