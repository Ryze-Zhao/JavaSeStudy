package com.zhaolearn.jdk8date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 格式化时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class FormatDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss")));
    }
}
