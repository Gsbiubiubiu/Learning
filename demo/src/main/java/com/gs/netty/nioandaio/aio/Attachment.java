package com.gs.netty.nioandaio.aio;

import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * @author: Gaos
 * @Date: 2023-03-22 23:38
 **/
@Data
public class Attachment {

    private AsynchronousServerSocketChannel server;
    private AsynchronousSocketChannel client;
    private boolean isReadMode;
    private ByteBuffer buffer;
}