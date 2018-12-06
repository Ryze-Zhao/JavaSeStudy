package com.zhaolearn.lambda;


//@FunctionalInterface可加可不加，建议加上，以免团队的其他人员错误地往接口中添加新的方法。
@FunctionalInterface
public interface LambdaInterface {
    int calculate(int a, int b);
}
