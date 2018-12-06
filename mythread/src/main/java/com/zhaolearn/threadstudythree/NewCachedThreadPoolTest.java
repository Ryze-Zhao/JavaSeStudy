package com.zhaolearn.threadstudythree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //循环10次
        for (int i = 0; i < 10; i++) {
            //用于输出的index
            final int index = i;

                //休息的时间，异常抛出，正常需要处理
                Thread.sleep( 2000);

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.print(index+" ");
                }
            });
            if(index==9){
                cachedThreadPool.shutdown();
            }
        }
    }
}
