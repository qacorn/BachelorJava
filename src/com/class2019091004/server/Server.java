package com.class2019091004.server;

import com.class2019091004.Address;

import java.nio.channels.AsynchronousServerSocketChannel;

public class Server {

    public static void main(String[] args) throws Exception {

        //打开服务器
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        //绑定主机
        server.bind(Address.loc);
        //接受客户端连接
        server.accept(server,new ServerHandler());

        Thread.sleep(10000);
    }
}
