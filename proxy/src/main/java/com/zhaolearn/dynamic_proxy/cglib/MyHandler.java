package com.zhaolearn.dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHandler implements MethodInterceptor {
    /**
     * 实现接口的invoke()方法，该方法用于对目标方法的增强处理，比如记录日志等。该方法的返回值就是代理对象执行目标方法的返回值。
     * 前面3个参数跟JDK动态代理一致
     * proxy 动态生成的代理对象
     * method 目标方法的实例（执行的目标方法对象）
     * args 目标方法的参数（ 执行目标方法对象上的参数列表）
     * methodProxy
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //Before   动态代理的本质，就是使用反射机制实现！
        System.out.println("日志记录：方法开始");
        //代理类调用被代理类的方法
        Object result = methodProxy.invokeSuper(proxy, args);
        //After
        System.out.println("日志记录：方法结束");
        return result;
    }

    public Object getProxy(Class superclass) {
          /*
        //与下面二选一即可
        Enhancer enhancer = new Enhancer();
        //设置父类，被代理类(UserServiceImpl.class）
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback( new MyHandler());
        UserServiceImpl proxy= (UserServiceImpl) enhancer.create();
    */

        /*
         * Cg1ib：第三方提供的代理
         * 涉及的类：Enhancer创建代理对象的方法：create()参数：
         * 第一个参数：被代理类的字节码类型（固定写法）
         * 第二个参数：CallBack接口类型，使用其子接口MethodInterceptor实现代理（程序实现）
         */
        return Enhancer.create(superclass, this);
    }
}
