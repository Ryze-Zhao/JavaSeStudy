package com.zhaolearn.BufferedStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
    //写入数据
    public static void functionOne() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\IOstudy\\BufferedStreamStudy.txt", true));
        // 输出换行符
        //bos.write("\r\n".getBytes());
        // 输出内容
        bos.write("ABCDEFGHIJKLMNOPQRSTUVWSYZ".getBytes());
        // 刷新此缓冲的输出流
        bos.flush();
        // 关闭流
        bos.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedOutputStreamTest.functionOne();
        System.out.println("输出完成");
    }
}
