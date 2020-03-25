package com.class2019091004.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {

    //有客户端连接
    @Override
    public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
        //
        attachment.accept(attachment,new ServerHandler());

        System.out.println("有新连接" + result);
//        attachment.
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(result);

        result.read(byteBuffer,byteBuffer,new ReadHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
        System.out.println("error");
    }
}
