package com.gs.netty.nioandaio.bio;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author: Gaos
 * @Date: 2023-03-16 16:08
 **/
public class SocketHandler implements Runnable{

    private SocketChannel socketChannel;

    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            // 将请求读入 buffer 中
            int num;
            while ((num = socketChannel.read(buffer)) > 0) {
                // 读取 buffer 内容之前 先切换到读模式
                buffer.flip();

                // 提取buffer中的数据
                byte[] bytes = new byte[num];
                buffer.get(bytes);

                String re = new String(bytes, StandardCharsets.UTF_8);
                System.out.println("收到请求：" + re);

                // 回应客户端
                ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到了你的请求， 你的请求内容是：" + re).getBytes());
                socketChannel.write(writeBuffer);

                buffer.clear();

            }

        }catch (IOException e){
            IOUtils.closeQuietly(socketChannel);
        }
    }
}