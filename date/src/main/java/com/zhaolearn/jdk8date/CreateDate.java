package com.zhaolearn.jdk8date;

import java.time.*;

/**
 * 创建时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class CreateDate {
    public static void main(String[] args) {
        LocalDateTime ofTime = LocalDateTime.of(2019, 10, 1, 8, 8, 8);
        System.out.println("当前精确时间：" + ofTime);

        LocalDate localDate = LocalDate.of(2019, 10, 01);
        System.out.println("当前日期：" + localDate);

        LocalTime localTime = LocalTime.of(12, 01, 01);
        System.out.println("当天时间：" + localTime);
    }
}
