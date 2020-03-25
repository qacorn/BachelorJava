package com.class2018071601.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket ;
    private String name;

    public Client(String name){
        try {
            this.name = name;
            socket = new Socket("192.168.0.104",7080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void clientWriteMessage() {
        try {
            socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while ((hasRead = dataInputStream.read(bytes))>0){
                System.out.println(name + "收到消息:" + new String(bytes,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientReadMessage()  {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
            while (true){
                String s = scanner.nextLine();
                dataOutputStream.write(s.getBytes());
                dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
