package com.zhaolearn.threadstudyone;

/**
 * Hello world!
 *
 */
public class ExtendsThread extends Thread {//必须第一步，继承Thread
    //必须第二步，重写run方法
    @Override
    public void run(){
        System.out.println("我是重写的run方法啊1");
    }

    public static void main(String[] args) {
        //新建方法
        ExtendsThread hehe=new ExtendsThread();
        ExtendsThread hehe1=new ExtendsThread();
        //run起来
        hehe.run();
        hehe1.run();
    }
}
