package com.zhaolearn.datatype;

import java.util.List;

public class TestListParams {
    //int不会改变，因为这里只是传入值，而不是地址
    public static void changeInt(int i) {
        i = 10;
        System.out.println("形参："+i);
    }
    public static void changeInteger(Integer i) {
        System.out.println( i.hashCode());
        i = 10;
        System.out.println("形参："+i);
    }
    public static void changeString(String i) {
        System.out.println("传入后："+i.hashCode()+i);
        i = "改变";
        System.out.println("修改后："+i.hashCode()+i);
    }
    public static void changeStudent(Student haha) {
        System.out.println("传入了："+haha.hashCode()+haha.toString());
        Student wawa=new Student("hehe","haha");
        //这种会改变实参的值
      /*  haha.setName("修改后");
        haha.setPhone("修改了");*/
        //这个不会改变
        haha=wawa;
        System.out.println("修改后："+haha.hashCode()+haha.toString());
    }

    //会改变，因为hehe指向的地址就是List<Student> haha中的每一个Student的地址
    public static void changeStudentList(List<Student> haha) {
        System.out.println(haha.hashCode());
        Student wawa=new Student("hehe","haha");
        for (Student hehe : haha) {
     //这种会改变List<Student>的值，因为hehe对应List<Student> haha中的每一个Student的地址
           hehe.setName("修改后");
            hehe.setPhone("修改了");
    //这个不会改变，因为这个是另hehe改变了地址，而不是让List<Student> haha中的每一个Student的地址改变
            hehe=wawa;
        }
    }

    //List<String> 不会改变，因为这里实际没改变list里面对应每个String的值（也是地址），只是改变了hehe这个地址而已。
    public static void changeStringList(List<String> haha) {
        System.out.println(haha.hashCode());
        for (String hehe : haha) {
            System.out.println("List中的每一个String地址修改前" + hehe.hashCode());
            hehe = "修改后";
            System.out.println("List中的每一个String地址修改后" + hehe.hashCode());
        }
    }
    //List<String> 会改变，因为这里实际改变list里面对应每个String的值（也是地址）
    public static void changeStringList1(List<String> haha) {
        System.out.println(haha.hashCode());
        for (int i = 0; i < haha.size(); i++) {
            System.out.println("List中的每一个String地址修改前" + haha.get(i).hashCode());
            haha.set(i, "修改了" + i);
            System.out.println("List中的每一个String地址修改后" + haha.get(i).hashCode());
        }
    }

    public static void changeIntegerList1(List<Integer> haha) {
        System.out.println(haha.hashCode());
        for (int i = 0; i < haha.size(); i++) {
            System.out.println("修改前" + haha.get(i).hashCode());
            haha.set(i, 30 + i);
            System.out.println("修改后" + haha.get(i).hashCode());
        }
    }
}
