package com.zhaolearn.mysqlstudy.tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
    //刚刚新建数据库的路径，后面是避免时区错误
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8";
    public static final String USER = "root";//用户名
    public static final String PASSWORD = "mysql123";//密码
    private static Connection conn = null;
    static { //静态块 获取数据库的连接
        try {
            // 1.加载驱动程序,mysql在5.6后需要加入.cj；5.6前不需要
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);  // 2.获取数据库连接
        } catch (Exception e) {//捕捉异常
            e.printStackTrace();
        }
    }

    //向外提供获取连接的调用方法
    public static Connection getConnection() {
        return conn;
    }
}