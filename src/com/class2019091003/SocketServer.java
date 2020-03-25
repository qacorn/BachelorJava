package com.class2019091003;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        //1 创建服务端
        ServerSocket serverSocket = new ServerSocket();
        //2 绑定主机地址
        serverSocket.bind(Address.loc);
        //3 监听客户请求
        Socket socket = serverSocket.accept();

        //4  书写数据

        //5  读取数据

    }
}
