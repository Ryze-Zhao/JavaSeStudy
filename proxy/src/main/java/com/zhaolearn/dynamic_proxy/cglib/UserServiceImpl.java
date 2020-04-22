package com.zhaolearn.dynamic_proxy.cglib;

/**
 * 真实角色
 */
public class UserServiceImpl{
    public void select() {System.out.println("UserServiceImpl:::::select");}
    public void save() {System.out.println("UserServiceImpl:::::save");}
    public void delete() {System.out.println("UserServiceImpl:::::delete");}
    public void update() {System.out.println("UserServiceImpl:::::update");}
}
