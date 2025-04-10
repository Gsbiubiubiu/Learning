package com.gs.netty.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

/**
 * @author: Gaos
 * @Date: 2022-12-15 17:24
 **/
public class BufferTest {

    private void test1() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.flip();
        byteBuffer.compact();
        IntBuffer intBuffer = IntBuffer.allocate(1024);
        LongBuffer longBuffer = LongBuffer.allocate(1024);

        ByteBuffer wrap = ByteBuffer.wrap(new byte[1024]);
        IntBuffer wrap1 = IntBuffer.wrap(new int[1024]);
        LongBuffer wrap2 = LongBuffer.wrap(new long[1024]);
    }
}