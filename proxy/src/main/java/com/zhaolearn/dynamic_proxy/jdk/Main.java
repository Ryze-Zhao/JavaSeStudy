package com.zhaolearn.dynamic_proxy.jdk;

public class Main {
    public static void main(String[] args) {
        MyHandler myHandler = new MyHandler(new UserServiceImpl());
        //这里代理类proxy就是动态生成的
        UserService proxy =(UserService)myHandler.getProxy();
       //这个可以看到这个UserService已经是一个代理类，而不是UserServiceImpl了
        System.out.println("proxy的类型："+proxy.getClass().getName());
        proxy.save();
    }
}
