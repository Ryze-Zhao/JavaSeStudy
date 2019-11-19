package com.zhaolearn.jdk8date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 比较时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class ComparisonDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yestory = now.minusDays(1);
        System.out.println(now + "在" + yestory + "之后吗?" + now.isAfter(yestory));
        System.out.println(now + "在" + yestory + "之前吗?" + now.isBefore(yestory));

        // 时间差
        long day = yestory.until(now, ChronoUnit.DAYS);
        long month = yestory.until(now, ChronoUnit.MONTHS);
        long hours = yestory.until(now, ChronoUnit.HOURS);
        long minutes = yestory.until(now, ChronoUnit.MINUTES);
        System.out.println("相差月份" + month);
        System.out.println("相差天数" + day);
        System.out.println("相差小时" + hours);
        System.out.println("相差分钟" + minutes);

        // 距离JDK 14 发布还有多少天？
        LocalDate date = LocalDate.of(2096, 10, 19);
        LocalDate nowDate = LocalDate.now();
        System.out.println("距离2096-10-19还有：" + nowDate.until(date, ChronoUnit.DAYS) + "天");
    }
}
