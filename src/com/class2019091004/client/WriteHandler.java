package com.class2019091004.client;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {

    private final AsynchronousSocketChannel asc;

    public WriteHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            asc.write(buffer,buffer,this);
        }else {
            System.out.println("write sucess");
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("write fail");
    }
}
