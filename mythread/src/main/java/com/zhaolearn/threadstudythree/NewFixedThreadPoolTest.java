package com.zhaolearn.threadstudythree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        //创建线程池大小为4
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 20; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                        System.out.print(index+" ");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
