package com.class2019091004.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadHandler  implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ReadHandler(AsynchronousSocketChannel asynchronousSocketChannel) {
        this.asynchronousSocketChannel = asynchronousSocketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        if (attachment.hasRemaining()) {
            asynchronousSocketChannel.read(attachment,attachment,this);
        }
        System.out.println(new String(attachment.array(), 0, result));
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
