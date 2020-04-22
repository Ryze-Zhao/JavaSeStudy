package com.zhaolearn.static_proxy;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        UserServiceProxy proxy=new UserServiceProxy();
        proxy.setUserService(userService);
        proxy. delete();
    }
}
