package com.gs.netty.nioandaio.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author: Gaos
 * @Date: 2023-03-22 23:36
 *  AsynchronousServerSocketChannel
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        // 实例化并监听端口
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8080));
        // 自己定义一个Attachment 类，来传递一些信息
        Attachment att = new Attachment();
        att.setServer(server);

        server.accept(att, new CompletionHandler<AsynchronousSocketChannel, Attachment>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Attachment att) {
                try {
                    SocketAddress clientAddr = client.getRemoteAddress();
                    System.out.println("收到新的连接：" + clientAddr);

                    // 收到新的连接后，server应该重新调用accept方法等待新的连接
                    att.getServer().accept(att, this);

                    Attachment newAtt = new Attachment();
                    newAtt.setServer(server);
                    newAtt.setClient(client);
                    newAtt.setReadMode(true);
                    newAtt.setBuffer(ByteBuffer.allocate(2048));

                    // 这里也可以继续使用匿名实现类，为了代码美观所以创建了一个类
                    client.read(newAtt.getBuffer(), newAtt, new ChannelHandler());
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Attachment attachment) {
                System.out.println("accept failed");
            }
        });

        // 防止main线程退出
        try {
            Thread.currentThread().join();
        }catch (InterruptedException e) {

        }
    }
}