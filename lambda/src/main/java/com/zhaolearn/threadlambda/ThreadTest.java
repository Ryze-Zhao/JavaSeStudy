package com.zhaolearn.threadlambda;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello Thread!!!")).start();
        Runnable test1 = () -> System.out.println("Hello Runnable!!!");
        test1.run();
    }
}
