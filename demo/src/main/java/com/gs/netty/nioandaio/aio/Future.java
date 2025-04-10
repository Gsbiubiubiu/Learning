package com.gs.netty.nioandaio.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;

/**
 * @author: Gaos
 * @Date: 2023-03-22 23:24
 **/
public class Future {

    private void test() throws IOException {
        AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open().bind(null);

        listener.accept(new Object(), new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {

            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
    }

    private void fileChannel() throws IOException {
        // 实例化
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("/Users/test.txt"));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 异步文件通道的读操作和写操作都需要提供一个文件的开始位置，在这里文件的开始位置为0
        java.util.concurrent.Future<Integer> result = channel.read(buffer, 0);
    }
}