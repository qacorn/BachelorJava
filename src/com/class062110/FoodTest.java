package com.class062110;

public class FoodTest {

    public static void main(String[] args) {
        BuyFood buyFood = new BuyFoodWaiter();
        HotFood hotFood = new HotFoodWaiter();
        BringChopsticks bringChopsticks = new BringChopsticksWaiter();
//        buyFood.buyFood(hotFood,bringChopsticks);

        buyFood.buyFood(new HotFood() {
            @Override
            public void hotFood(BringChopsticks bringChopsticks) {
                System.out.println("hot food");
            }
        }, new BringChopsticks() {
            @Override
            public void bringChopsticks() {
                System.out.println("bring Chopsticks");
            }
        });

//        buyFood.buyFood(new HotFood() {
//            @Override
//            public void hotFood() {
//
//            }
//        });

    }
}
