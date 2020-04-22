package com.zhaolearn.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHandler implements InvocationHandler {
    //被代理的类
    private Object target;

    //定义含参构造方法，该参数为要代理的实例对象，目的是用于执行method.invoke()方法（也就是执行目标方法）
    public MyHandler(Object object) {
        super();
        this.target = object;
    }

    /**
     * 实现接口的invoke()方法，该方法用于对目标方法的增强处理，比如记录日志等。该方法的返回值就是代理对象执行目标方法的返回值。
     * proxy 动态生成的代理对象
     * method 目标方法的实例（执行的目标方法对象）
     * args 目标方法的参数（ 执行目标方法对象上的参数列表）
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Before   动态代理的本质，就是使用反射机制实现！
        System.out.println("日志记录：方法开始");
        Object result = method.invoke(target, args);
        //After
        System.out.println("日志记录：方法结束");
        return result;
    }

    public Object getProxy() {
//        动态代理的作用：在不更改源码的情况下，对己有方法进行增强JDK动态代翼：基于接口
//        涉及的类：Proxy创建代理对象的方法：newProryInstanceO其参数：
//          第一个参数：被代理对象的类的加载器，（固定写法）
//          第二个参数：被代理对象的接口类型（固定写法）
//          第三个参数：代理对象的具体实现（需要去实现）（我们这个类已经实现了）
        //返回代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
