package com.class2018071601.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Server {

    private List<Socket> socketList;
    private ServerSocket serverSocket;
    private OnSocketConnect onSocketConnect;

    public Server() {
        try {
            serverSocket = new ServerSocket(7080);
            System.out.println("服务端已经启动,正在监听7080端口");
            for (int i = 0; i < 10; i++) {
                Socket socket = serverSocket.accept();
                System.out.println("第" + (i+1) + "个客户端已连接");
                socketList.add(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverSingleClose() throws IOException {
//        outputStream.close();
//        inputStream.close();
//        socket.close();
//        serverSocket.close();
    }

    public void serverWriteMessage(Socket socket) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
            Scanner scanner = new Scanner(System.in);
//            boolean continueWrite = true;
            while (true){
                String s = scanner.nextLine();
                dataOutputStream.write(s.getBytes());
                dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverReadMessage(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            byte[] readBuffer = new byte[1024];
            int hadRead = 0;
            while ((hadRead = dataInputStream.read(readBuffer))>0){
                String receive = new String(readBuffer,0,hadRead);
                if (receive.equals("quit")){
//                    close();
                }
                System.out.println(new String(readBuffer,0,hadRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOnSocketConnect(OnSocketConnect onSocketConnect) {
        this.onSocketConnect = onSocketConnect;
    }
}
