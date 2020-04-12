package com.zhaolearn.jdk8date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 加减时间
 * @author: HeHaoZhao
 * @date: 2019/11/19 14:53
 */
public class AddAndSubtractDate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间："+now);
        LocalDateTime plusTime = now.plusMonths(1).plusDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        System.out.println("增加1月1天1小时1分钟1秒时间后：" + plusTime);
        LocalDateTime minusTime = now.minusMonths(2);
        System.out.println("减少2个月时间后：" + minusTime);
    }
}
