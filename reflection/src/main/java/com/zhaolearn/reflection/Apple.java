package com.zhaolearn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Apple {
    private String name;
    public String getName() { return name;}
    public void setName(String name) {this.name = name; }

    public static void main(String[] args) throws Exception {
        Apple apple=new Apple();
        apple.setName("My name is apple");

        System.out.println("Apple:"+apple.getName());

        Class clz = Class.forName("com.zhaolearn.reflection.Apple");
        Constructor constructor = clz.getConstructor();
        Object appleObject = constructor.newInstance();
        Method setMethod = clz.getMethod("setName", String.class);
        setMethod.invoke(appleObject, "My name is apple");

        Method getMethod = clz.getMethod("getName");
        System.out.println("getMethod:"+getMethod.invoke(appleObject));
    }
}
