package com.class2018071601.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {

    private static ExecutorService executorService = Executors.newFixedThreadPool(6);

    public static void main(String[] args) {

        final Server server = new Server();
        server.setOnSocketConnect(new OnSocketConnect() {
            @Override
            public void socketConnect() {
//                clientConversion(server);
            }
        });


    }

//    private static void clientConversion(ServerThread server) {
//        executorService.execute(new Runnable() {
//            public void run() {
//                server.serverReadMessage();
//            }
//        });
//
//        executorService.execute(new Runnable() {
//            public void run() {
//                server.serverWriteMessage();
//            }
//        });
//    }
}
