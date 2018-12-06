package com.zhaolearn.EfficientStream;


import java.io.*;

public class EfficientStream {
    //FileInputStream读取文件后 FileOutputStream再次输出一个文件，一次读写一个字节
    public static void functionOne() throws IOException {
        FileInputStream fileTest1 = new FileInputStream("D:\\IOstudy\\TestVideo.mp4");
        FileOutputStream filtTest2 = new FileOutputStream("D:\\IOstudy\\StreamTest1.mp4");
        // 开始时间
        long begin = System.currentTimeMillis();
        int len;
        while ((len = fileTest1.read()) != -1) {
            filtTest2.write(len);
        }
        System.out.println("functionOne运行时间为"+(System.currentTimeMillis() - begin+"秒"));
        fileTest1.close();
        filtTest2.close();
    }
    //FileInputStream读取文件后 FileOutputStream再次输出一个文件，一次读写一个字节数组
    public static void functionTwo() throws IOException {
        FileInputStream fileTest1 = new FileInputStream("D:\\IOstudy\\TestVideo.mp4");
        FileOutputStream filtTest2 = new FileOutputStream("D:\\IOstudy\\StreamTest2.mp4");
        byte[] byteOne=new byte[1024];
        // 开始时间
        long begin = System.currentTimeMillis();
        int len;
        //fileTest1.read(byteOne,0,byteOne.length预防把剩下的空数据也写入，造成一些文件格式的损坏和文件大小增大
        while ((len = fileTest1.read(byteOne,0,byteOne.length)) != -1) {
            filtTest2.write(byteOne,0,len);
        }
        System.out.println("functionTwo运行时间为"+(System.currentTimeMillis() - begin)+"秒");
        fileTest1.close();
        filtTest2.close();
    }
    //BufferedInputStream读取文件后 BufferedOutputStream再次输出一个文件，一次读写一个字节数组
    public static void functionThree() throws IOException {
        BufferedInputStream fileTest1 = new BufferedInputStream(new FileInputStream("D:\\IOstudy\\TestVideo.mp4"));
        BufferedOutputStream filtTest2 = new BufferedOutputStream(new FileOutputStream("D:\\IOstudy\\StreamTest3.mp4"));
        byte[] byteOne=new byte[1024];
        // 开始时间
        long begin = System.currentTimeMillis();
        int len;
        //fileTest1.read(byteOne,0,byteOne.length预防把剩下的空数据也写入，造成一些文件格式的损坏和文件大小增大
        while ((len = fileTest1.read(byteOne,0,byteOne.length)) != -1) {
            filtTest2.write(byteOne, 0, len);
        }
        System.out.println("functionThree运行时间为"+(System.currentTimeMillis() - begin)+"毫秒");
        fileTest1.close();
        filtTest2.close();
    }

    public static void main(String[] args) throws IOException {
        EfficientStream.functionOne();
        EfficientStream.functionTwo();
        EfficientStream.functionThree();
    }
}
