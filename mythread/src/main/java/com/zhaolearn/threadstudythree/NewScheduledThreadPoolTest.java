package com.zhaolearn.threadstudythree;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟一秒后，每3秒执行一次");
            }
            //如果只输入一个数字的话，代表延迟N秒，执行
        }, 1, 3, TimeUnit.SECONDS);
    }
}
