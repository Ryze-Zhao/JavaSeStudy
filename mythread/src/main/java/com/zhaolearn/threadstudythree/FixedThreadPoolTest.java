package com.zhaolearn.threadstudythree;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor hehe=new ThreadPoolExecutor(3,3,10,TimeUnit.SECONDS,new ArrayBlockingQueue(10));

    }
}
