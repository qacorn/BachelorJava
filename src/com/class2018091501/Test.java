package com.class2018091501;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args) {

        Random random = new Random();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(random.nextInt(10000)+1000);
            userList.add(user);
        }

        for (User user : userList) {
            System.out.println("UserID == " + user.getUserId());
        }
        System.out.println("=============================================================");
        userList.sort(Comparator.comparing(User::getUserId).reversed());

        for (User user : userList) {
            System.out.println("UserID == " + user.getUserId());
        }

        User user = userList.get(0);
        System.out.println(user.getUserId());
    }
}
