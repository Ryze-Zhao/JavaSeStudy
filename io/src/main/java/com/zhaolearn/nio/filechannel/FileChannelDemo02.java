package com.zhaolearn.nio.filechannel;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo02 {
    public static void main(String[] args) throws Exception {
        //1、创建文件的输入流
        File file = new File("d:\\FileChannelDemo01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //2、通过fileInputStream 获取对应的FileChannel -> 实际类型  FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();
        //3、创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //4、将通道的数据读入到Buffer
        fileChannel.read(byteBuffer);
        //5、将byteBuffer 的 字节数据 转成String
        System.out.println(new String(byteBuffer.array()));
        //6、关闭流
        fileInputStream.close();
    }
}
