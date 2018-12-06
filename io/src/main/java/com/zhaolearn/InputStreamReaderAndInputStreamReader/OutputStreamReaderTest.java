package com.zhaolearn.InputStreamReaderAndInputStreamReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamReaderTest {
    public static void functionOne() throws IOException {
        //生成字符缓冲流对象,不写字符编码，使用默认编码
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("D:\\IOstudy\\InputStreamReaderAndInputStreamReader.txt"), "utf-8");
        String writerStr = "ABCDEFGHIJKLMNOPQRSTUVWSYZ什么";
        writer.write(writerStr);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        OutputStreamReaderTest.functionOne();
    }
}
