package com.class2018071602;

import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 7080);

        Thread writeThread = new Thread(new WriteRunner(socket));
        writeThread.start();
        Thread readThread = new Thread(new ReadRunner(socket));
        readThread.start();

        writeThread.join();
        readThread.join();

        socket.close();

    }
}
