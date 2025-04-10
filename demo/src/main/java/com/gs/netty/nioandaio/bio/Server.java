package com.gs.netty.nioandaio.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: Gaos
 * @Date: 2023-03-16 16:03
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 监听8080 端口进来的tcp连接
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {

                // 这里会阻塞，直到有一个请求的连接进入
                SocketChannel socketChannel = serverSocketChannel.accept();
                // 这里开启一个新的线程来处理这个请求，然后在while循环中继续监听8080端口
                SocketHandler handler = new SocketHandler(socketChannel);
                new Thread(handler).start();
        }

    }
}