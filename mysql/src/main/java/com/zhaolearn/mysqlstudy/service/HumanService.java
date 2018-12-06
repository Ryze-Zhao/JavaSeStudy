package com.zhaolearn.mysqlstudy.service;

import com.zhaolearn.mysqlstudy.entity.Human;
import com.zhaolearn.mysqlstudy.tools.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HumanService {
    private Connection connection = JdbcUtil.getConnection();

    //增加Huamn
    public void addHuman(Human human) throws Exception {
        String sql = " insert into human(name,age)values(?,?)";
        PreparedStatement ptmt = connection.prepareStatement(sql);// 预编译sql语句 在excute的时候真正执行
        ptmt.setString(1, human.getName());  // 传递参数 补充完整的sql
        ptmt.setString(2, human.getAge() + "");//由于参数是需要String的
        ptmt.execute();
    }
}
