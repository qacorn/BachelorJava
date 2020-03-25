package com.class2018071701;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientBai {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        final Client clientWangWei = new Client("白居易");

        executorService.execute(new Runnable() {
            public void run() {
                clientWangWei.clientReadMessage();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                clientWangWei.clientWriteMessage();
            }
        });

    }
}
