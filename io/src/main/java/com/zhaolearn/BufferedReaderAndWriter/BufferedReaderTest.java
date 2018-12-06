package com.zhaolearn.BufferedReaderAndWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void functionOne() throws IOException {
        //生成字符缓冲流对象
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IOstudy\\BufferedWriterAndReader.txt")));
        String str;
        //一次性读取一行
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }
        //关闭流
        reader.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReaderTest.functionOne();
    }
}
