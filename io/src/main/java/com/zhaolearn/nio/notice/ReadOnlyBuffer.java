package com.zhaolearn.nio.notice;

import java.nio.ByteBuffer;

/**
 * ​2、可以将一个普通Buffer转成只读Buffer，但对改只读Buffer进行Put时会丢出ReadOnlyBufferException
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        //创建一个buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);
        for(int i = 0; i < 64; i++) {
            buffer.put((byte)i);
        }
        //读取
        buffer.flip();
        //得到一个只读的Buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        //读取，是成功的
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }
        //对readOnlyBuffer这个只读Buffer进行Put时，会丢出ReadOnlyBufferException
        readOnlyBuffer.put((byte)100);
    }
}
