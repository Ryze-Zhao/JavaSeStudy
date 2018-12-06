package com.zhaolearn.threadstudytwo;

/**
 * @Note:同步代码块的根据参数锁；（实例对象锁和class对象锁）
 * @Author:HaoZhao
 * @Date:2018/10/16 10:58
 **/
public class SynchronizationThread2 implements Runnable {
    //共享资源(临界资源)
    static int i = 0;

    @Override
    public void run() {
        //当参数为this时，表示当前实例对象锁，那么主函数传入的对象必须是同一个，才能正确运算，否则不同对象，照样没锁；
        //当参数为SynchronizationThread2.class,那么，锁住的是这个Class，多个实例对象依然能正确运算；但是效率低下；
        //如果能保证传入的对象相同，建议使用this，否则使用Class对象锁
        synchronized(this){
        for (int j = 0; j < 10000; j++) {
            i++;
        }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizationThread2 hehe = new SynchronizationThread2();
        Thread one = new Thread(hehe);
        Thread two = new Thread(hehe);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(i);
    }

}
