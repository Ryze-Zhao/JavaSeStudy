package com.zhaolearn.FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {
    //@Note:一次读一字节，（暂时不支持中文，需要自己研究）
    public static void functionOne() throws IOException {
        InputStream inputone = new FileInputStream(new File("D:\\IOstudy\\FileStreamStudy.txt"));
        int i = 0;
        //一次读取一个字节
        while ((i = inputone.read()) != -1) {
            // System.out.print(i + " ");// 65 66 67 68
            //输出65 66 67 68？输出字符对应的ASCII码。
            System.out.print((char) i + " ");// A B C D
        }
        //关闭IO流
        inputone.close();
    }
    //按字节数组的下标，一次读那么多个字符（暂时不支持中文，需要自己研究）
    public static void functionTwo() throws IOException {
        //构造方法2
        InputStream inputStream2 = new FileInputStream("D:\\IOstudy\\FileStreamStudy.txt");
        // 字节数组,下标代表就是一次显示多少个
        byte[] b = new byte[2];
        int i2 = 0;
        //  一次读取一个字节数组
        while ((i2 = inputStream2.read(b)) != -1) {
            System.out.print(new String(b, 0, i2) + " ");// AB CD
        }
        //关闭IO流
        inputStream2.close();
    }
    public static void main(String[] args) throws IOException {
            FileInputStreamTest.functionTwo();
    }
}
