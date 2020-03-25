package com.class2019091002;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //1 创建客户端
        DatagramSocket datagramSocket = new DatagramSocket();

        for (int i = 0; true; i++) {



            //2 准备数据

                Scanner scanner = new Scanner(System.in);
                String content = scanner.nextLine();
                if ("stop".equals(content)) {
                    break;
                }
                byte[] bytes = "客户端：?".concat(content).getBytes();
                //3 创建集装箱
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                // 设置收件地址
                datagramPacket.setSocketAddress(Address.loc);

                //4 发送数据
                datagramSocket.send(datagramPacket);


                //1 创建新的集装箱
                byte[] bs = new byte[1024];
                DatagramPacket res = new DatagramPacket(bs, bs.length);
                //2 接受数据
                datagramSocket.receive(res);
                //3 打印数据
                System.out.println(new String(res.getData(), 0, res.getLength()));
            }

        // 关闭资源
        datagramSocket.close();
    }
}
