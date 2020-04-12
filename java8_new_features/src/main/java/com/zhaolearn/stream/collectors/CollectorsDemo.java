package com.zhaolearn.stream.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {
    public static void main(String[] args){
        List<Student> studentList = Stream.of(
                new Student(1, "Java"), new Student(2, "PHP"),
                new Student(3, "Python"), new Student(4, "C/C++"),
                new Student(5, "Java"), new Student(1, "Java"), new Student(1, "Java1111111111")).collect(Collectors.toList());

        //toList    把流中元素收集到List
        List<String> stringList = studentList.stream().map(Student::getName).collect(Collectors.toList());
        stringList.forEach(e -> System.out.println("Collectors.toList()----------->" + e));

        //toSet     把流中元素收集到Set
        Set<String> stringSet = studentList.stream().map(Student::getName).collect(Collectors.toSet());
        stringSet.forEach(e -> System.out.println("Collectors.toSet()----------->" + e));

        //toMap     注:key不能相同，否则报错;第一个参数就是用来生成key值的(这里用Num作key)，第二个参数就是用来生成value值的（e->e意思是用这个Student作值）。
        //第三个参数用在key值冲突的情况下：如果新元素产生的key在Map中已经出现过了，第三个参数就会定义解决的办法（之前已经存在这个key的时候以第一个出现Student作值）
        Map<Integer, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getNum,e->e,(e1,e2)->e1));
        studentMap.forEach((key, value) -> System.out.println("Collectors.toMap()----------->Key: " + key +", value: "+ value));

        //toCollection  把流中元素收集到创建的集合

        //joining   连接流中每个字符串
        String joinName1 = studentList.stream().map(Student::getName).collect(Collectors.joining());
        String joinName2 = studentList.stream().map(Student::getName).collect(Collectors.joining(","));
        String joinName3 = studentList.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")"));
        System.out.println("Collectors.joining()joinName1----------->" + joinName1);
        System.out.println("Collectors.joining()joinName2----------->" + joinName2);
        System.out.println("Collectors.joining()joinName3----------->" + joinName3);

        //collectingAndThen     包裹另一个收集器，对其结果转换函数
        Integer collectingAndThen = studentList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println("Collectors.collectingAndThen----------->" + collectingAndThen);

        //groupingBy    根据某属性值对流分组，属性为K，结果为V
        Map<String, Map<Integer, List<Student>>> groupingBy = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getNum)));
        groupingBy.forEach((key, value) -> System.out.println("groupingBy----------->Key: " + key +", value: "+ value));
        //多重分组，先分Num，再分姓名
        Map<String, Map<Integer, List<Student>>> groupingByMany = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getNum)));
        groupingByMany.forEach((key, value) -> System.out.println("groupingByMany----------->Key: " + key +", value: "+ value));


        //partitioningBy    根据true或false进行分区
        Map<Boolean, List<Student>> partMap = studentList.stream().collect(Collectors.partitioningBy(e -> e.getNum() > 2));
        partMap.forEach((key, value) -> System.out.println("partitioningBy----------->Key: " + key +", value: "+ value));


        //counting  计算流中元素的个数
        Long countingLong = studentList.stream().collect(Collectors.counting());
        //summingInt    对流中元素的整数属性求和
        Integer summingInt = studentList.stream().collect(Collectors.summingInt(Student::getNum));
        //averagingInt  计算流中元素lnteger属性的平均值
        Double averagingInt = studentList.stream().collect(Collectors.averagingInt(Student::getNum));
        //summarizinglnt    收集流中integer属性的统计值。如：平均值
        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(Collectors.summarizingInt(Student::getNum));
        System.out.println("countingLong----------->"+countingLong+"             summingInt----------->"+summingInt+"            averagingInt----------->"+averagingInt
                   +"            intSummaryStatistics----------->"+intSummaryStatistics.toString());
        //maxBy     根据比较器选择最大值
        //minBy     根据比较器选择最小值
        Optional<Student> studentOptional = studentList.stream().collect(Collectors.maxBy((o1, o2) -> {
            //自定义排序：先按姓名升序，姓名相同则按学号升序
            if (o1.getName().equals(o2.getName())) {
                return o1.getNum() - o2.getNum();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }));
        Student maxByStudent = studentOptional.get();
        System.out.println("Collectors.maxBy----------->" + maxByStudent.toString());

        //reducing  从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值
        Integer allNum = studentList.stream().map(Student::getNum).collect(Collectors.reducing(Integer::sum)).get();
        System.out.println("Collectors.reducing----------->" + allNum);

        //mapping   类似 Stream 先进行了 map 操作再进行 collect
        List<Student> studentList1 = studentList.stream().collect(Collectors.mapping(e -> e.mapStudentDemo(), Collectors.toList()));
        studentList1.forEach(System.out::println);



    }
}
