package com.class062110;

public class BuyFoodWaiter implements BuyFood {

    @Override
    public void buyFood(HotFood hotFood,BringChopsticks bringChopsticks) {
        System.out.println("BuyFoodWaiter   buyFood");
//        hotFood.hotFood(BringChopsticks bringChopsticks);
        hotFood.hotFood(bringChopsticks);
        bringChopsticks.bringChopsticks();
    }
}
