package com.class2018071701;

import java.io.*;
import java.net.Socket;
import java.net.SocketOption;

public class ServerThread implements Runnable{

    private Socket socket;
    private SocketOption socketOption = new SocketOption<String>() {
        @Override
        public String name() {
            return "ClientName";
        }

        @Override
        public Class<String> type() {
            return String.class;
        }
    };

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            byte[] readBuffer = new byte[1024];
            int hadRead = 0;
            while ((hadRead = dataInputStream.read(readBuffer))>0){
                String receive = new String(readBuffer,0,hadRead);
                if (receive.startsWith("myname:")){
                    String name = receive.substring(7);
                    System.out.println(name);
//                    socket.setOption(socketOption,name);
                    continue;
                }
                if (receive.equals("bye")){
//                    socket.close();
                    MyServer.socketList.remove(socket);
                    break;
                }
                System.out.println(receive);
                for (int i = 0; i < MyServer.socketList.size(); i++) {
                    Socket otherSocket = MyServer.socketList.get(i);
                    if (otherSocket != socket) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(otherSocket.getOutputStream());
                        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
                        StringBuffer stringBuffer = new StringBuffer();
//                        stringBuffer.append("client").append(socket.getInetAddress()).append(socket.getOption("ClientName")).append("发来的消息:").append(receive);
                        stringBuffer.append("client").append(socket.getInetAddress()).append("发来的消息:").append(receive);
                        dataOutputStream.write(stringBuffer.toString().getBytes());
                        dataOutputStream.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
