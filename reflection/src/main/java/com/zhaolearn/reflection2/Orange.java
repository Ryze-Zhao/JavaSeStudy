package com.zhaolearn.reflection2;

public class Orange implements fruit {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("This is a Orange");
    }
}
