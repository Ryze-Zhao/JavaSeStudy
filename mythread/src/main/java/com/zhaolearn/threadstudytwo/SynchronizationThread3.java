package com.zhaolearn.threadstudytwo;

/**
 * @Note:同步代码块,使用静态实例对象，直接锁实例对象
 * @Author:HaoZhao
 * @Date:2018/10/16 10:58
 **/
public class SynchronizationThread3 implements Runnable {
    static SynchronizationThread3 staticInstance=new SynchronizationThread3();
    //共享资源(临界资源)
    static int i = 0;
    @Override
    public void run() {
        //当参数为this时，表示当前实例对象锁，那么主函数传入的对象必须是同一个，才能正确运算，否则不同对象，照样没锁；
        //这种直接使用静态的，保证了唯一性，但是觉得不太好
        synchronized(staticInstance){
        for (int j = 0; j < 10000; j++) {
            i++;
        }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(staticInstance);
        Thread two = new Thread(staticInstance);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(i);
    }

}
