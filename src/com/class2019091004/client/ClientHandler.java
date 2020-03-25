package com.class2019091004.client;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ClientHandler  implements CompletionHandler<Void, AsynchronousSocketChannel> {

    //连接上服务器将触发该方法
    @Override
    public void completed(Void result, AsynchronousSocketChannel attachment) {
        System.out.println("已连接");
        ByteBuffer byteBuffer = ByteBuffer.wrap("客户端：你好，能收到吗？".getBytes());
        attachment.write(byteBuffer,byteBuffer,new WriteHandler(attachment));
    }

    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel attachment) {

    }
}
