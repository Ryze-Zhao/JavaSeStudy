package com.zhaolearn.InputStreamReaderAndInputStreamReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void functionOne() throws IOException {
        //使用默认编码,我的平台设置了utf-8
        InputStreamReader reader = new InputStreamReader(new FileInputStream
                ("D:\\IOstudy\\InputStreamReaderAndInputStreamReader.txt"));
        int len;
        while ((len = reader.read()) != -1) {
            System.out.print((char) len);
        }
        reader.close();
    }
    public static void functionTwo() throws IOException {
        //指定编码，指定gbk,因为写入是utf-8，会出问题
        InputStreamReader reader = new InputStreamReader(new FileInputStream
                ("D:\\IOstudy\\InputStreamReaderAndInputStreamReader.txt"), "gbk");
        int len;
        while ((len = reader.read()) != -1) {
            System.out.print((char) len);
        }
        reader.close();
    }
    public static void main(String[] args) throws IOException {
        InputStreamReaderTest.functionTwo();
    }
}
