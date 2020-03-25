package com.class2019091004.client;

import com.class2019091004.Address;

import java.nio.channels.AsynchronousSocketChannel;

public class Client {

    public static void main(String[] args) throws Exception {
        //打开客户端
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();

        //连接服务器（异步）
        client.connect(Address.loc,client,new ClientHandler());

        Thread.sleep(100);
    }
}
