package com.zhaolearn.nio.filechannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannelDemo04 {
    public static void main(String[] args)  throws Exception {
        //1、创建文件输入输出流
        FileInputStream fileInputStream = new FileInputStream("d:\\FileChannelDemo01.txt");
        FileChannel sourceCh = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\FileChannelDemoCP.txt");
        FileChannel destCh = fileOutputStream.getChannel();
        //2、使用transferForm完成拷贝
        destCh.transferFrom(sourceCh,0,sourceCh.size());
        //关闭相关通道和流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
