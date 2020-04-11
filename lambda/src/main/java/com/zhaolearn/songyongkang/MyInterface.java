package com.zhaolearn.songyongkang;

/**
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 * 7. 函数式接口不能有多个方法
 *
 * 自定义函数式接口
 */
@FunctionalInterface
public interface MyInterface {
    void method1();
//函数式接口只允许一个抽象方法
//    void method2();
}
