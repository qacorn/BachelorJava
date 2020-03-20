package com.class2018070502;

public class AddNumber {

    private AddNumber() {
        System.out.println("AddNumber 构造方法");
    }

    private static AddNumber addNumber;

    public  static AddNumber getInstance(){
        if (addNumber == null){
            addNumber = new AddNumber();
        }
        return addNumber;
    }

    private int number = 0;

    public void addNumber(){
        number ++;
        System.out.println("addNumber的值为:" + number);
    }
}
