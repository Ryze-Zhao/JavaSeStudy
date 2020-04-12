package com.zhaolearn.jdk8date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 转换时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class ChangeDate {
    public static void main(String[] args) {
        LocalDateTime parseTime = LocalDateTime.parse("2019-10-01T22:22:22.222");
        System.out.println("字符串时间转换：" + parseTime);

        LocalDate formatted = LocalDate.parse("20190101", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("字符串时间转换-指定格式：" + formatted);

        // Date 转换成 LocalDateTime
        Date date = new Date();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("Date 转换成 LocalDateTime：" + LocalDateTime.ofInstant(date.toInstant(), zoneId));

        // LocalDateTime 转换成 Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Date toDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime 转换成 Date：" + toDate);

        // 当前时间转时间戳
        long epochMilli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("当前时间转时间戳：" + epochMilli);
        // 时间戳转换成时间
        LocalDateTime epochMilliTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
        System.out.println("时间戳转换成时间：" + epochMilliTime);
    }
}

