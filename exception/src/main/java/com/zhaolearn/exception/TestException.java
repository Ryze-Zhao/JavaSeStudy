package com.zhaolearn.exception;

/**
 * Hello world!
 */
public class TestException {
    // add就是做一下加法，如果数字不符合要求就有异常，如果定义的是运行时异常就不用抛异常了
    public int add(int one, int two) throws MyException {// 抛出自己的异常类
        int a = 0;
        //如果给入的数字one和two是0就抛出异常
        if (one == 0 || two == 0) {
            // 分数不合法时抛出异常
            throw new MyException("你给入的数字不符合要求");// new一个自己的异常类
        } else {
            a = one + two;
        }
        return a;
    }

    public static void main(String[] args) {
        TestException test = new TestException();
        try {
            int a = test.add(0, 1);
            System.out.println("AddResult："+a);
        } catch (MyException e) {
            System.out.println("You give me 0");
            e.printStackTrace();
        }
    }
}
