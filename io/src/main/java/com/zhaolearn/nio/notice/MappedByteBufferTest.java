package com.zhaolearn.nio.notice;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 3、NIO还提供了MappedByteBuffer，可以让文件直接在内存（堆外的内存）中进行修改，操作系统不需要拷贝一次，而如何同步到文件由NIO来完成.
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:\\FileChannelDemoCP.txt", "rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();
        /**
         * 参数1: FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数2： 0 ： 可以直接修改的起始位置
         * 参数3:  5: 是映射到内存的大小(不是索引位置) ,即将 1.txt 的多少个字节映射到内存
         * 可以直接修改的范围就是 0-4（索引位置），共参数3（5）个索引
         * MappedByteBuffer的实际类型是DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        mappedByteBuffer.put(7, (byte) 'H');
        mappedByteBuffer.put(8, (byte) '9');
        mappedByteBuffer.put(9, (byte) 'Y');//IndexOutOfBoundsException
        randomAccessFile.close();
        System.out.println("修改成功~~");
    }
}
