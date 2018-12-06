package com.zhaolearn.BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {
    //读取数据
    public static void functionOne() throws IOException {
        // 字节缓存流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\IOstudy\\BufferedStreamStudy.txt"));
        //每次读取30字节
        byte[] bs = new byte[30];
        int len = 0;
        while ((len = bis.read(bs)) != -1) {
            System.out.print(new String(bs, 0, len));
        }
        // 关闭流
        bis.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedInputStreamTest.functionOne();
        System.out.println("读取完成");
    }
}
