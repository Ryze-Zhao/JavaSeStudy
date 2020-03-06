package com.zhaolearn.nio.filechannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo03 {
    public static void main(String[] args) throws Exception {
        //1、创建文件输入输出流
        FileInputStream fileInputStream = new FileInputStream("d:\\FileChannelDemo01.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\FileChannelDemoCP.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();
        //2、创建并设置Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        //3、循环读取,read返回的是未读字节数（学习Java是10字节，因此第一次读取为10），当fileChannel01.read(byteBuffer)==-1时，代表byteBuffer已经被读取完毕。
        while (fileChannel01.read(byteBuffer) != -1) {
            //反转
            byteBuffer.flip();
            //将buffer 中的数据写入到 fileChannel02 -- 即FileChannelDemo03.txt中
            fileChannel02.write(byteBuffer);
            //（重点）清空buffer，不然byteBuffer会是第一次的数据，那么代表永远有数据，即fileChannel01.read(byteBuffer)永远不会等于-1，即陷入无限写出到FileChannelDemo03.txt。
            byteBuffer.clear();
        }
        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
