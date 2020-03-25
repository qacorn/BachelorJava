package com.class2018071601.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientDu {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        final Client clientWangWei = new Client("杜甫");

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
