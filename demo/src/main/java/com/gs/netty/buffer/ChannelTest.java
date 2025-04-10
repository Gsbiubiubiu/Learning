package com.gs.netty.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author: Gaos
 * @Date: 2023-03-16 09:48
 **/
public class ChannelTest {

    private void init() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("/data.txt"));
        FileChannel channel = fileInputStream.getChannel();

        FileChannel channel1 = new RandomAccessFile("/data.txt", "r").getChannel();
    }
}