package com.zhaolearn.datatype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTestDataType {
    /**
     * 测试int,基本类型，不会修改
     */
    @Test
    public void testInt() {
        int i=99;
        TestListParams.changeInt(i);
        System.out.println(i);
    }
    @Test
    public void testInteger() {
        Integer i=99;
        System.out.println(i.hashCode());
        TestListParams.changeInt(i);
        System.out.println(i);
    }
    @Test
    public void testString() {
        String i="haha";
        System.out.println("传入前："+i.hashCode()+i);
        TestListParams.changeString(i);
        System.out.println("结束："+i.hashCode()+i);
    }
    /**
     * 测试单个实体类，发现会改变，引用类型
     */
    @Test
    public void testStudent() {
       Student haha=new Student("测试","测试");
        System.out.println("传入前："+haha.hashCode()+haha.toString());
        TestListParams.changeStudent(haha);
        System.out.println(haha.hashCode()+haha.toString());
    }
    /**
     * 测试实体类，发现会改变，引用类型
     */
    @Test
    public void testStudentList() {
        List<Student> wawa=new ArrayList<>();
        for(int i=0;i<5;i++){
            wawa.add(new Student("测试名字"+i,"测试电话"+i));
        }
        System.out.println(wawa.hashCode());
        wawa.stream().forEach(e->System.out.println(e));
        System.out.println("----------------");
        TestListParams.changeStudentList(wawa);
        wawa.stream().forEach(e->System.out.println(e));
    }
    /**
     * 测试String，是引用类型,发现会不会改变，是看写法的
     */
    @Test
    public void testStringList() {
        List<String> wawa=new ArrayList<>();
        for(int i=0;i<5;i++){
            wawa.add("测试"+i);
        }
        System.out.println("传入前："+wawa.hashCode());
        wawa.stream().forEach(e->System.out.println(e));
        System.out.println("----------------");
        TestListParams.changeStringList1(wawa);
        System.out.println("结束："+wawa.hashCode());
        wawa.stream().forEach(e->System.out.println(e));
    }
    /**
     * 测试Integer，是引用类型,发现会不会改变，是看写法的
     */
    @Test
    public void testIntegerList() {
        List<Integer> wawa=new ArrayList<>();
        for(int i=0;i<5;i++){
            wawa.add(i);
        }
        System.out.println(wawa.hashCode());
        wawa.stream().forEach(e->System.out.println(e));
        System.out.println("----------------");
        TestListParams.changeIntegerList1(wawa);
        wawa.stream().forEach(e->System.out.println(e));
    }
}
