package com.zhaolearn.jdk8date;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 创建时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class ExpansionDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        // 第一天
        LocalDateTime firstDay = now.withDayOfMonth(1);
        System.out.println("本月第一天：" + firstDay);
        // 当天最后一秒
        LocalDateTime lastSecondOfDay = now.withHour(23).withMinute(59).withSecond(59);
        System.out.println("当天最后一秒：" + lastSecondOfDay);
        LocalDateTime lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("This month last day:" + lastDay);
        // 是否闰年
        System.out.println("今年是否润年：" + Year.isLeap(now.getYear()));
    }
}
