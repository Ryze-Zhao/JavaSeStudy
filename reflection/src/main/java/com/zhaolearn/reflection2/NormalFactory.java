package com.zhaolearn.reflection2;

public class NormalFactory {
    public static fruit getInstance(String fruitName){
        fruit f=null;
        if("Banana".equals(fruitName)){
            f=new Banana();
        }
        if("Orange".equals(fruitName)){
            f=new Orange();
        }
        return f;
    }
    public static void main(String[] a){
        fruit f=NormalFactory.getInstance("Orange");
        f.eat();
    }
}
