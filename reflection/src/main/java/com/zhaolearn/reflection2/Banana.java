package com.zhaolearn.reflection2;

public class Banana implements fruit {
    private String name;
    public String getName() { return name;}
    public void setName(String name) {this.name = name; }

    @Override
    public void eat() {
        System.out.println("This is a Banana");
    }
}
