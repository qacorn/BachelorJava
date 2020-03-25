package com.class2018071602;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadRunner implements Runnable {
    private Socket socket;

    public ReadRunner(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        byte[] readBuffer = new byte[1024];
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            while (true) {
                int readNum = dataInputStream.read(readBuffer);
                String requestInfo = new String(readBuffer, 0, readNum);
                System.out.println("他说：" + requestInfo);
                if ("bye".equals(requestInfo)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
