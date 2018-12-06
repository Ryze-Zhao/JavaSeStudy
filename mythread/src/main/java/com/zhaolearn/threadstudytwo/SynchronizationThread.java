package com.zhaolearn.threadstudytwo;

/**
 * @Note:同步方法
 * @Author:HaoZhao
 * @Date:2018/10/16 10:58
 **/
public class SynchronizationThread implements Runnable {
    //共享资源(临界资源)
    static int i = 0;
    //按理2个线程操作完为20000，但是没加synchronized时，运行结果并不是
   /*public void increase() {
        i++;
    }*/
    //按理2个线程操作完为20000，加synchronized时，运行结果正确
    public synchronized void increase() {
        i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizationThread hehe = new SynchronizationThread();
        Thread one = new Thread(hehe);
        Thread two = new Thread(hehe);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(i);
    }

}
