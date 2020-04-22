package com.zhaolearn.dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl proxy= (UserServiceImpl) new MyHandler().getProxy(UserServiceImpl.class);
        //这个可以看到这个UserService已经是一个代理类，而不是UserServiceImpl了
        System.out.println("proxy的类型："+proxy.getClass().getName());
        proxy.save();
    }
}
