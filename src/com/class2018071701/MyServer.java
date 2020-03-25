package com.class2018071701;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyServer {

    public static final AtomicInteger CURRENT_CHAT_NUM = new AtomicInteger(0);

    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>(100));



    public void startService(){
        try {
            ServerSocket serverSocket = new ServerSocket(7080);
            System.out.println("服务端已经启动,正在监听7080端口");
            while (true){
                Socket socket = serverSocket.accept();
                getSocketList().add(socket);
                new Thread(new ServerThread(socket)).start();
//                Executors.newCachedThreadPool(new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        CURRENT_CHAT_NUM.compareAndSet(2,5);
//                        CURRENT_CHAT_NUM.getAndIncrement();//a++
//
//                        CURRENT_CHAT_NUM.incrementAndGet();//++a
//                        return null;
//                    }
//                });

                ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r,"chat_thread_" + CURRENT_CHAT_NUM.getAndIncrement());
                        t.setDaemon(true);
                        return t;
                    }
                });
                executorService.execute(new ServerThread(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<Socket> getSocketList() {
        return socketList;
    }
}
