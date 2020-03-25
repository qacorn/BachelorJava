package com.class2018071602;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        //打开服务进程
        ServerSocket serverSocket = new ServerSocket(7080);
        System.out.println("服务端已经启动，正在监听7080端口");

        //获取端口监听到的请求
        Socket socket = serverSocket.accept();

        //获取请求信息
        ReadRunner readRunner = new ReadRunner(socket);
        Thread thread = new Thread(readRunner);
        thread.start();

        //给客户端响应
        WriteRunner writeRunner = new WriteRunner(socket);
        Thread writeThread = new Thread(writeRunner);
        writeThread.start();

        thread.join();
        writeThread.join();

        socket.close();
        serverSocket.close();
    }
}


