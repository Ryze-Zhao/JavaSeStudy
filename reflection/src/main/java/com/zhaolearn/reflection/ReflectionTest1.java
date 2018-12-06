package com.zhaolearn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class ReflectionTest1 {
    public static void main(String[] args) throws Exception {
        Apple apple=new Apple();
        apple.setName("My name is apple");

        Class clz = Class.forName("com.zhaolearn.reflection.Apple");
        Method method = clz.getMethod("setName", String.class);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object, "My name is apple");


    }
}
