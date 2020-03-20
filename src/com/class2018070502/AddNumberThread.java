package com.class2018070502;

public class AddNumberThread extends Thread{

 public AddNumber addNumber = AddNumber.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            addNumber.addNumber();
        }
    }
}
