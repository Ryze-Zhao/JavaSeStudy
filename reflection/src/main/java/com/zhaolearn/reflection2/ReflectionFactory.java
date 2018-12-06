package com.zhaolearn.reflection2;

public class ReflectionFactory {
    public static fruit getInstance(String fruitName){
        fruit f=null;
        try{
            f=(fruit)Class.forName(fruitName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public static void main(String[] a){
        //这里传入的需要是包含包路径和名字的String
        fruit f=ReflectionFactory.getInstance("com.zhaolearn.reflection2.Banana");
        f.eat();
    }
}
