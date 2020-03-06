package com.zhaolearn.nio.buffer;

import java.nio.IntBuffer;

/**
 * 可以通过打断点观察Buffer中4个重要属性的变化情况。
 */
public class BufferDemo {
    public static void main(String[] args) {
        //创建一个Buffer, 大小为 5, 即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //向buffer 存放数据0，2，4，6，8
        for(int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put( i * 2);
        }
        //如何从buffer读取数据，将buffer转换，读写切换( intBuffer.flip())
        intBuffer.flip();
//        intBuffer.position(1);//1,2
//        System.out.println(intBuffer.get());
//        intBuffer.limit(3);
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
