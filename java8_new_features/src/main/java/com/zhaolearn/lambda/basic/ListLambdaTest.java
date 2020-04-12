package com.zhaolearn.lambda.basic;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class ListLambdaTest {
    public static void main(String[] args) {
        List<Student> hehe = new ArrayList<Student>();
        //导入数据
        for (int i = 0; i < 10; i++) {
            hehe.add(new Student(i, "名字" + i, 20 + i, "你是哪里人" + i));
        }
        hehe.add(new Student(10, "新添加" + 6, 99, "你是哪里人" + 99));//用于按要求查找

   /*     //遍历
       hehe.forEach(e -> {
            System.out.println(e);
        });
        System.out.println("");
        //查找出年龄小于25岁的学生
        hehe.stream().filter(e -> e.getAge() < 25).forEach(e -> System.out.println(e));
        System.out.println("");
        //模糊查找名字带有添加，并且年龄大于28的
        hehe.stream().filter(e -> e.getName().indexOf("添加") != -1 && e.getAge() > 28).forEach(e -> System.out.println(e));*/
        //按照名字的倒序遍历
        hehe.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).forEach(e -> System.out.println(e));
        //按照年龄倒序遍历，这个不太好
        hehe.stream().sorted((o1, o2) -> (o2.getAge()+"").compareTo(o1.getAge()+"")).forEach(e -> System.out.println(e));


        //按照年龄的倒序为主要，名字的倒序为第二，可以一直设置下去，进行排序，然后下一句输出
        hehe.sort(comparing(Student::getAge).reversed().thenComparing(comparing(Student::getName).reversed()));
        hehe.forEach(System.out::println);
        //按照年龄的倒序为主要，名字的倒序为第二，可以一直设置下去，进行排序，然后遍历
        hehe.stream().sorted(comparing(Student::getAge).reversed().thenComparing(comparing(Student::getName).reversed())).forEach(Student::toString);
    }
}
