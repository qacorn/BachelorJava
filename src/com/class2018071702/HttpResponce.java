package com.class2018071702;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpResponce {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7080);
            System.out.println("服务端已经启动,正在监听7080端口");
            Socket socket = serverSocket.accept();

            /**
             *
             *
             *
             */



            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append("HTTP/1.1 200 OK").append("Server Apache-Coyote/1.1");

            dataOutputStream.write(stringBuffer.toString().getBytes());
            dataOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
