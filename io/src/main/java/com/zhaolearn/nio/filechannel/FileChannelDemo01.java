package com.zhaolearn.nio.filechannel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo01 {
    public static void main(String[] args) throws Exception{
        //注：英文及英文符号占1字节，中文及中文符号占3字节，换行等占2字节。那么"学习Java"占用10字节
        String str = "学习Java";
        //1、创建一个输出流->channel，关联到指定的文件
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\FileChannelDemo01.txt");
        //2、通过 fileOutputStream 获取 对应的 FileChannel（那么这个渠道就与指定文件关联了）
        //这个 fileChannel 真实 类型是  FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();
        //3、创建一个缓冲区 ByteBuffer（参数的字节数一定要大于str的字节数）
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //4、将 str 放入 byteBuffer
        byteBuffer.put(str.getBytes());
        //5、对byteBuffer 进行flip（必须反转）
        byteBuffer.flip();
        //6、将byteBuffer 数据写入到 fileChannel（这时操作fileChannel，其实就是往FileChannelDemo01.tx写入byteBuffer的数据）
        fileChannel.write(byteBuffer);
        //7、关闭流
        fileOutputStream.close();
    }
}
