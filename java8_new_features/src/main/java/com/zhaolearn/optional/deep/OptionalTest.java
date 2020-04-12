package com.zhaolearn.optional.deep;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 *
 * 2    方法
 * 2.1    创建Optional类对象的方法：
 * 2.1.1    Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
 * 2.1.2    Optional.empty() : 创建一个空的 Optional 实例
 * 2.1.3    Optional.ofNullable(T t)：t可以为null
 *
 * 2.2    判断Optional容器中是否包含对象：
 * 2.2.1    boolean isPresent() : 判断是否包含对象
 * 2.2.2    void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
 *
 * 2.3    获取Optional容器的对象：
 * 2.3.1    T get(): 如果调用对象包含值，返回该值，否则抛异常
 * 2.3.2    T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
 * 2.3.3    T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
 * 2.3.4    T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
 *
 * 常用的方法：ofNullable(T t)
 *              orElse(T t)
 */
import org.junit.Test;

public class OptionalTest {
    /*
    Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    Optional.empty() : 创建一个空的 Optional 实例
    Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test1() {
//        Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional<Girl> optionalGirl = Optional.of(new Girl());
//        Optional.empty() : 创建一个空的 Optional 实例
        Optional<Girl> optionalGir2 = Optional.empty();
//        Optional.ofNullable(T t)：t可以为null
        Optional<Girl> optionalGir3 = Optional.ofNullable(new Girl());
        Optional<Girl> optionalGir4 = Optional.ofNullable(null);
        System.out.println(optionalGirl+"----------"+optionalGir2+"----------"+optionalGir3+"----------"+optionalGir4);
//       输出 Optional[Girl(name=null)]----------Optional.empty----------Optional[Girl(name=null)]----------Optional.empty
    }

    @Test
    public void test2() {
        Optional<Girl> optionalGirl = Optional.of(new Girl("GrilName"));
//        boolean isPresent() : 判断是否包含对象
        boolean optionalGirlPresent = optionalGirl.isPresent();
        System.out.println(optionalGirlPresent);
//        void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
        Consumer<Girl> tConsumer = e -> System.out.println(e.toString());
        optionalGirl.ifPresent(tConsumer);
        optionalGirl.ifPresent(System.out::println);
//      输出  true----------Girl(name=GrilName)----------Girl(name=GrilName)
    }

    @Test
    public void test3() throws Exception {
        Optional<Girl> optionalGirl = Optional.of(new Girl("GrilName"));
//        T get(): 如果调用对象包含值，返回该值，否则抛异常
        Girl girl = optionalGirl.get();
//        T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
        Girl girl1 = optionalGirl.orElse(new Girl("GrilNameDefault"));
//        T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
        Girl girl2 = optionalGirl.orElseGet(() -> new Girl("GrilNameDefault"));
//        T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。（自己想要什么异常就什么异常）
        Girl girl3 = optionalGirl.orElseThrow(Exception::new);
        System.out.println(girl+"----------"+girl1+"----------"+girl2+"----------"+girl3);
//      可以自己试一试传一个空的Optional测试
//      输出   Girl(name=GrilName)----------Girl(name=GrilName)----------Girl(name=GrilName)----------Girl(name=GrilName)
    }


    /**
     * 事例，加入Boy里有一个Girl，Girl有一个名字，我们需要获取Girl的名字
     *
     */
    @Test
    public void test4() {
//        Boy boy = null;
//        Boy boy = new Boy();
      Boy  boy = new Boy(new Girl("GirlName"));
        //分别测试上面3种Boy与下面3种getGirlName方法的组合结果
//        String girlName = getGirlName(boy);
//        String girlName = getGirlName1(boy);
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    public String getGirlName(Boy boy) {
        //无论boy还是girl为null都会丢出异常
        return boy.getGirl().getName();
    }

    //优化以后的getGirlName():
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    //使用Optional类的getGirlName():
    public String getGirlName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //此时的boy1一定非空
//        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Boy是null")));
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Boy是null")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("Girl是null"));
        return girl1.getName();
    }
}
