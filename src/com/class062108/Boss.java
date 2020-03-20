package com.class062108;

public class Boss implements CallBackInterface,CallBack2{

    void work(){
        System.out.println("I work!");
    }

    @Override
    public void tellMe() {
        System.out.println("done");
    }

    @Override
    public void addChopstick() {

    }
}
