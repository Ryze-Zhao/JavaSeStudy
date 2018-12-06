package com.zhaolearn.threadstudytwo;

/**
 * @Note:使用特殊域变量(volatile)实现线程同步
 * @Author:HaoZhao
 * @Date:2018/10/16 10:58
 **/
public class SynchronizationThread6Volatile {
    private volatile int i = 0;

    public void addNumFunction(int addNum) {
       i+=addNum;
        System.out.println("于" + System.currentTimeMillis() + "增加：" + addNum);
    }

    public void reduceNumFunction(int reduceNum) {
        if (i - reduceNum < 0) {
            System.out.println("不能小于0");

        }else {
            i -= reduceNum;
            System.out.println("于" + System.currentTimeMillis() + "减少：" + reduceNum);
        }
    }

    // 查询
    public void queryNum() {
        System.out.println("目前NUM：" + i);
    }


    public static void main(String args[]) {
        final SynchronizationThread6Volatile hehe = new SynchronizationThread6Volatile();
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
