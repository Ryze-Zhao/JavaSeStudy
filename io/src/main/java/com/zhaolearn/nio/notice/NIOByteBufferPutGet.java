package com.zhaolearn.nio.notice;

import java.nio.ByteBuffer;

/**
 * 1、ByteBuffer支持类型化的put和get,put放入的是什么数据类型，get就应该使用相应的数据类型来取出，否则可能有BufferUnderflowException异常。
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        //创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);
        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('学');
        buffer.putShort((short) 4);
        //取出
        buffer.flip();
        //正常取出
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        //以下会丢出BufferUnderflowException异常
//        System.out.println(buffer.getInt());
//        System.out.println(buffer.getLong());
//        System.out.println(buffer.getLong());
//        System.out.println(buffer.getShort());
    }
}
