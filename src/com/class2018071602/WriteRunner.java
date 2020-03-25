package com.class2018071602;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteRunner implements Runnable {
    private Socket socket;

    public WriteRunner(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        Scanner scanner = null;
        try {
            outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
            scanner = new Scanner(System.in);
            String inputInfo = "";
            while (!"bye".equals(inputInfo)) {
                inputInfo = scanner.nextLine();
                dataOutputStream.write(inputInfo.getBytes());
                dataOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
