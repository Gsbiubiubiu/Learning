package com.gs.netty.nioandaio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Gaos
 * @Date: 2023-03-16 16:40
 **/
public class SelectorServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel server = ServerSocketChannel.open();
        server.socket().bind(new InetSocketAddress(8080));

        // 将其注册到 selector 中，监听OP_ACCEPT事件
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannels = selector.select();
            if(readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            // 遍历
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();

                if(key.isAcceptable()) {
                    // 有已经接受的新的到服务器上的连接
                    SocketChannel socketChannel = server.accept();

                    // 有新的连接不代表这个通道内就有数据
                    // 这里将这个新的 SocketChannel 注册到 Selector，监听OP_READ 事件，等待数据写入
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);

                }else if(key.isReadable()) {
                    // 有数据可读
                    // 上面一个if分支中注册了监听 OP_READ事件的SocketChannel
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int num = socketChannel.read(readBuffer);
                    if(num > 0) {
                        // 处理进来的数据。。。
                        System.out.println("收到数据：" + new String(readBuffer.array()).trim());
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端的数据。。。".getBytes());
                        socketChannel.write(buffer);
                    }else if (num == -1) {
                        // -1表示连接已经关闭
                        socketChannel.close();
                    }
                }
            }

        }

    }
}