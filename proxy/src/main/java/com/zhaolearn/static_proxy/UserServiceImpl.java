package com.zhaolearn.static_proxy;

/**
 * 真实角色
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {System.out.println("UserServiceImpl:::::select");}
    @Override
    public void save() {System.out.println("UserServiceImpl:::::save");}
    @Override
    public void delete() {System.out.println("UserServiceImpl:::::delete");}
    @Override
    public void update() {System.out.println("UserServiceImpl:::::update");}
}
