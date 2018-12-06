package com.zhaolearn.BufferedReaderAndWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterTest {
    public static void functionOne() throws IOException {
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\IOstudy\\BufferedWriterAndReader.txt"),"utf-8"));
        String writerStr = "ABCDEFGHIJKLMNOPQRSTUVWSYZ什么BufferedWriter";
        writer.write(writerStr);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriterTest.functionOne();
    }
}
