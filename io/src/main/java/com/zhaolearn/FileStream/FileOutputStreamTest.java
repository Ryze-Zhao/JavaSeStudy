package com.zhaolearn.FileStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
    //写入数据
    public static void functionOne() throws IOException {
        OutputStream outputStream = new FileOutputStream(new File("D:\\IOstudy\\FileStreamStudy.txt"));
        // 写出数据
        outputStream.write("ABCDEFGHIJKLMNOPQRSTUVWSYZ".getBytes());
        // 关闭IO流
        outputStream.close();
    }
    //追加数据
    public static void functionTwo() throws IOException {
        // 内容追加写入
        OutputStream outputStream2 = new FileOutputStream("D:\\IOstudy\\FileStreamStudy.txt", true);
        // 输出换行符
        //outputStream2.write("\r\n".getBytes());
        // 输出追加内容
        outputStream2.write("hehaozhao".getBytes());
        // 关闭IO流
        outputStream2.close();
    }
    public static void main(String[] args) throws IOException {
        FileOutputStreamTest.functionOne();
        FileOutputStreamTest.functionTwo();
    }
}
