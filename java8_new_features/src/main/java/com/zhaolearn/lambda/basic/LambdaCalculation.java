package com.zhaolearn.lambda.basic;

/**
 * Hello world!
 */
public class LambdaCalculation {
    public static void main(String[] args) {
        //接收2个参数，不写类型，也不写return，直接返回他们的和
        LambdaInterface addition = (h, e) -> e + h;
        //接收2个参数，写类型，写retrun，返回值为他们的差
        LambdaInterface subtraction = (int h, int e) -> { return h - e; };
        //接收2个参数，写类型，不写retrun，返回值为他们的积
        LambdaInterface multiplication = (int h, int e) -> e * h;
        //接收2个参数，不写类型，写retrun，返回值为他们的商
        LambdaInterface division = (h, e) -> {return h / e; };
        //使用calculate后，实际获得就是计算结果
       System.out.println("加法="+addition.calculate(10, 5));
        System.out.println("减法="+subtraction.calculate(10, 5));
        System.out.println("乘法="+multiplication.calculate(10, 5));
        System.out.println("除法="+division.calculate(10, 5));
    }
}