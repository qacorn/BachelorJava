package com.class062110;

public class HotFoodWaiter implements HotFood{

    @Override
    public void hotFood(BringChopsticks bringChopsticks) {
        System.out.println("HotFoodWaiter  hotFood");
        bringChopsticks.bringChopsticks();
    }
}
