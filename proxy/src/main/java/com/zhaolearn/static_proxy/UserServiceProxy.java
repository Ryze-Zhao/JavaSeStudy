package com.zhaolearn.static_proxy;

/**
 * 代理角色
 */
public class UserServiceProxy implements UserService {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void select() {
        log("select");
        userService.select();
    }
    @Override
    public void save() {
        log("save");
        userService.save();
    }
    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }
    @Override
    public void update() {
        log("update");
        userService.update();
    }
    //日志方法
    public void log(String operate) {
        System.out.println("日志记录~~~~~~~~~~~~~：" + operate);
    }
}
