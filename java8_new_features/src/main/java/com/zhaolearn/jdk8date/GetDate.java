package com.zhaolearn.jdk8date;

import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 * 获取时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class GetDate {
    public static void main(String[] args) {
        // 当前精确时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前精确时间：" + now);
        System.out.println("当前精确时间：" + now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth() + " " + now.getHour() + "-" + now.getMinute() + "-" + now.getSecond());

        // 有时区的当前精确时间
        ZonedDateTime nowZone = LocalDateTime.now().atZone(ZoneId.systemDefault());
        System.out.println("当前精确时间（有时区）：" + nowZone);
        System.out.println("当前精确时间（有时区）：" + nowZone.getYear() + "-" + nowZone.getMonthValue() + "-" + nowZone.getDayOfMonth() + " " + nowZone.getHour() + "-" + nowZone.getMinute() + "-" + nowZone.getSecond());

        // 获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期：" + localDate);
        System.out.println("当前日期：" + localDate.getYear() + "-" + localDate.getMonthValue() + "-" + localDate.getDayOfMonth());

        // 获取当天时间
        LocalTime localTime = LocalTime.now();
        System.out.println("当天时间：" + localTime);
        System.out.println("当天时间：" + localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond());
    }
}
