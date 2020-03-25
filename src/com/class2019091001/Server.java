package com.class2019091001;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        //1创建客户端
        DatagramSocket socket = new DatagramSocket(Address.loc);
        //2 创建集装箱
        byte[]  bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        //3 接受数据
        socket.receive(packet);
        //4 打印数据
        System.out.println(new String(packet.getData(),0,packet.getLength()));


        //1 准备数据
        byte[] bts = "server receive ".getBytes();
        //2 创建新的集装箱
        DatagramPacket res = new DatagramPacket(bts,bts.length,packet.getAddress(),packet.getPort());
        //3 发送数据
        socket.send(res);

        //关闭资源
        socket.close();
    }

}
