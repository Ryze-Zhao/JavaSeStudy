package com.zhaolearn.threadstudytwo;

/**
 * @Note:使用局部变量实现线程同步
 * @Author:HaoZhao
 * @Date:2018/10/16 10:58
 **/
public class SynchronizationThread5ThreadLocal {
    private static ThreadLocal<Integer> localThread = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 200;
        }
    };

    public void addNumFunction(int addNum) {
        localThread.set(localThread.get() + addNum);
        System.out.println("于" + System.currentTimeMillis() + "增加：" + addNum);
    }

    public void reduceNumFunction(int reduceNum) {
        if (localThread.get() - reduceNum < 0) {
            System.out.println("不能小于0");

        }else {
            localThread.set(localThread.get() - reduceNum);
            System.out.println("于" + System.currentTimeMillis() + "减少：" + reduceNum);
        }
    }

    // 查询
    public void queryNum() {
        System.out.println("目前NUM：" + localThread.get());
    }


    public static void main(String args[]) {
        final SynchronizationThread5ThreadLocal hehe = new SynchronizationThread5ThreadLocal();
        Thread tadd = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    hehe.addNumFunction(100);
                    hehe.queryNum();
                    System.out.println();
                }
            }
        });
        Thread tsub = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    hehe.reduceNumFunction(200);
                    hehe.queryNum();
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        tsub.start();
        tadd.start();
    }
}
