package com.zhaolearn.threadstudyone;

public class ImplementsRunnable implements Runnable{//必须第一步实现接口
   //给个名字，可以不做
    private String name;
    public ImplementsRunnable() {
    }
    public ImplementsRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {//必须第二步，实现接口方法
        System.out.println("我是Runnable接口");
    }
    public static void main(String[] args) {
        //不给名字的，也可以给
        ImplementsRunnable hehe=new ImplementsRunnable();
        Thread mythrea=new Thread(hehe);
        mythrea.start();
        //第二种给个名字的，也可以不给
        new Thread(new ImplementsRunnable("Thread2")).start();
    }
}
