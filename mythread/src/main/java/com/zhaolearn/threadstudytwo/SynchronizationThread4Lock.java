package com.zhaolearn.threadstudytwo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Note:使用重入锁实现线程同步
 * @Author:HaoZhao
 * @Date:2018/10/16 10:58
 **/
public class SynchronizationThread4Lock implements Runnable {
    //共享资源(临界资源)
    static int i = 0;
    //需要声明这个锁
    private Lock lock = new ReentrantLock();
    public void save(int count) {
        lock.lock();//获得锁
        try {
            i += count;
        } finally {
            lock.unlock();//释放锁
        }
    }
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            save(1);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizationThread4Lock hehe = new SynchronizationThread4Lock();
        Thread thread1 = new Thread(hehe);
        Thread thread2 = new Thread(hehe);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }


}
