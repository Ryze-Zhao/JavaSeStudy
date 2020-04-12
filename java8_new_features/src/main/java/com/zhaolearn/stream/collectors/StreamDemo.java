package com.zhaolearn.stream.collectors;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamDemo {

    public static void main(String[] args) throws FileNotFoundException {
        /**
         * 以下为Stream的创建流方式
         *
         */
        List<String> gList = Stream.of("a","b","c","d","e").collect(Collectors.toList());
        //创建流：二1、使用Collection下的 stream() 和 parallelStream() 方法
        //获得串行流
       Stream<String> gStream1= gList.stream();
        //获得并行流
        Stream<String> gStream2= gList.parallelStream();

        //创建流：二2、使用Arrays 中的 stream() 方法，将数组转成流
        Integer[] nums = new Integer[10];
        Stream<Integer> gStream3 = Arrays.stream(nums);

        //创建流：二3、使用Stream中的静态方法：of()、iterate()、generate()
        Stream<Integer> gStream4 = Stream.of(0,2,4,6,8);
        Stream<Integer> gStream5 = Stream.iterate(1, (x) -> x + 2).limit(5);
        gStream5.forEach(System.out::println); //1 3 5 7 9
        Stream<Double> gStream6 = Stream.generate(Math::random).limit(5);
        gStream6.forEach(System.out::println);//随机5个数字

        //创建流：二4、使用 BufferedReader.lines() 方法，将每行内容转成流
//        BufferedReader reader = new BufferedReader(new FileReader("C:\\stream.txt"));
//        Stream<String> gStream7 = reader.lines();
//        gStream7.forEach(System.out::println);


        //创建流：二5、使用 Pattern.splitAsStream() 方法，将字符串分隔成流
        Pattern pattern = Pattern.compile(",");
        Stream<String> gStream8 = pattern.splitAsStream("a,b,c,d");
        gStream8.forEach(System.out::println);

        /**
         * 以下为Stream的数据源
         *
         */
        //其实如果这里是Stream<Student>那么剩下的演示都不需要 studentList.stream()这样转变了
        List<Student> studentList = Stream.of(
                new Student(1, "Java"), new Student(2, "PHP"),
                new Student(3, "Python"), new Student(4, "C/C++"),
                new Student(5, "Java"), new Student(1, "Java")).collect(Collectors.toList());
        List<String> flatMap = Stream.of("a,b,c", "1,2,3").collect(Collectors.toList());
        List<String> sorted = Stream.of("b", "a", "z", "e", "c").collect(Collectors.toList());
        List<Integer> countList = Stream.of(1, 2, 3, 5, 5, 21, 35, 7, 5).collect(Collectors.toList());
        List<Integer> reduceList = Stream.of(1, 2, 3, 5, 5, 21, 35, 7, 5).collect(Collectors.toList());


        /**
         * 以下为Stream的中间操作，可以无限中间操作
         *
         */

        /**
         * 以下为Stream的中间操作的筛选和切片
         *
         */
        //  filter      接收Lambda，从流中排除某些元素。
        studentList.stream().filter(e -> e.getNum() > 2).forEach(e -> System.out.println("filter----------->" + e.toString()));
        //结果
//        filter----------->Student(num=3, name=Python)
//        filter----------->Student(num=4, name=C/C++)
//        filter----------->Student(num=5, name=Java

        //  distinct    筛选，通过流所生成元素的hashCode（）和equals（）去除重复元素
        studentList.stream().distinct().forEach(e -> System.out.println("distinct----------->" + e.toString()));
        //结果
//        distinct----------->Student(num=1, name=Java)
//        distinct----------->Student(num=2, name=PHP)
//        distinct----------->Student(num=3, name=Python)
//        distinct----------->Student(num=4, name=C/C++)
//        distinct----------->Student(num=5, name=Java)


        //limit(long maxsize)       截断流，使其元素不超过给定数量。
        studentList.stream().limit(2L).forEach(e -> System.out.println("limit----------->" + e.toString()));
        //结果
//        limit----------->Student(num=1, name=Java)
//        limit----------->Student(num=2, name=PHP)


        //skip（long n）跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与1imit（n）可做成分页
        studentList.stream().skip(3L).forEach(e -> System.out.println("skip----------->" + e.toString()));
        //结果
//        skip----------->Student(num=4, name=C/C++)
//        skip----------->Student(num=5, name=Java)
//        skip----------->Student(num=1, name=Java)



        /**
         * 以下为Stream的中间操作的映射
         *
         */
        //map（Function f）接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        studentList.stream().map(e -> e.mapStudentDemo()).forEach(e -> System.out.println("mapStudentDemo----------->" + e.toString()));
        studentList.stream().map(e -> e.mapNameDemo()).forEach(e -> System.out.println("mapNameDemo----------->" + e));
        //结果
//        mapStudentDemo----------->Student(num=1, name=Java:mapStudentDemo)
//        mapStudentDemo----------->Student(num=2, name=PHP:mapStudentDemo)
//        mapStudentDemo----------->Student(num=3, name=Python:mapStudentDemo)
//        mapStudentDemo----------->Student(num=4, name=C/C++:mapStudentDemo)
//        mapStudentDemo----------->Student(num=5, name=Java:mapStudentDemo)
//        mapStudentDemo----------->Student(num=1, name=Java:mapStudentDemo)
//        mapNameDemo----------->Java:mapStudentDemo:mapNameDemo
//        mapNameDemo----------->PHP:mapStudentDemo:mapNameDemo
//        mapNameDemo----------->Python:mapStudentDemo:mapNameDemo
//        mapNameDemo----------->C/C++:mapStudentDemo:mapNameDemo
//        mapNameDemo----------->Java:mapStudentDemo:mapNameDemo
//        mapNameDemo----------->Java:mapStudentDemo:mapNameDemo


        //peek  如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。
        studentList.stream().peek(e -> e.setName(e.getName() + "peek")).forEach(e -> System.out.println("peek----------->" + e.toString()));
        //结果
//        peek----------->Student(num=1, name=Java:mapStudentDemo:mapNameDemopeek)
//        peek----------->Student(num=2, name=PHP:mapStudentDemo:mapNameDemopeek)
//        peek----------->Student(num=3, name=Python:mapStudentDemo:mapNameDemopeek)
//        peek----------->Student(num=4, name=C/C++:mapStudentDemo:mapNameDemopeek)
//        peek----------->Student(num=5, name=Java:mapStudentDemo:mapNameDemopeek)
//        peek----------->Student(num=1, name=Java:mapStudentDemo:mapNameDemopeek)


        //参考名称和map就可以明白了
        studentList.stream().mapToDouble(e -> e.getNum()).forEach(e -> System.out.println("mapToDouble----------->" + e));
        studentList.stream().mapToInt(e -> e.getNum()).forEach(e -> System.out.println("mapToInt----------->" + e));
        studentList.stream().mapToLong(e -> e.getNum()).forEach(e -> System.out.println("mapToLong----------->" + e));
        //结果
//        mapToInt----------->1
//        mapToInt----------->2
//        mapToInt----------->3
//        mapToInt----------->4
//        mapToInt----------->5
//        mapToInt----------->1
//        mapToLong----------->1
//        mapToLong----------->2
//        mapToLong----------->3
//        mapToLong----------->4
//        mapToLong----------->5
//        mapToLong----------->1

        //flatMap（Function f）   接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        flatMap.stream().flatMap(e -> {
                    //将每个元素转换成一个Stream,并且返回，最后所有元素的所有流在汇集在一起，连接成一个流
                    String[] split = e.split(",");
                    return Arrays.stream(split);
                }
        ).forEach(e -> System.out.println("flatMap----------->" + e));
        //结果
//        flatMap----------->a
//        flatMap----------->b
//        flatMap----------->c
//        flatMap----------->1
//        flatMap----------->2
//        flatMap----------->3


        /**
         * 以下为Stream的中间操作的排序
         *
         */
        //sorted（）  产生一个新流，其中按自然顺序排序
        sorted.stream().sorted().forEach(e -> System.out.println("sorted----------->" + e));
        //结果
//        sorted----------->a
//        sorted----------->b
//        sorted----------->c
//        sorted----------->e
//        sorted----------->z


        //sorted（Comparator comp）产生一个新流，其中按比较器顺序排序(自定义排序)
        studentList.stream().sorted((o1, o2) -> {
            //自定义排序：先按姓名升序，姓名相同则按学号升序
            if (o1.getName().equals(o2.getName())) {
                return o1.getNum() - o2.getNum();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }).forEach(e -> System.out.println("sorted----------->" + e));
        //结果
//        sorted----------->Student(num=4, name=C/C++:mapStudentDemo:mapNameDemopeek)
//        sorted----------->Student(num=1, name=Java:mapStudentDemo:mapNameDemopeek)
//        sorted----------->Student(num=1, name=Java:mapStudentDemo:mapNameDemopeek)
//        sorted----------->Student(num=5, name=Java:mapStudentDemo:mapNameDemopeek)
//        sorted----------->Student(num=2, name=PHP:mapStudentDemo:mapNameDemopeek)
//        sorted----------->Student(num=3, name=Python:mapStudentDemo:mapNameDemopeek)


        /**
         * 以下为Stream的终止操作，终止操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如List、Integer 甚至是void。
         *
         */
        /**
         * 以下为Stream的终止操作的查找与匹配
         *
         */
        //allMatch（Predicate p）检查是否匹配所有元素
        boolean allMatch = studentList.stream().allMatch(e -> e.getNum() > 10); //false
        System.out.println("allMatch----------->" + allMatch);
        //anyMatch（Predicate p）检查是否至少匹配一个元素
        boolean noneMatch = studentList.stream().noneMatch(e -> e.getNum() > 10); //true
        System.out.println("noneMatch----------->" + noneMatch);
        //nonelMatch（Predicate p）检查是否没有匹配所有元素
        boolean anyMatch = studentList.stream().anyMatch(e -> e.getNum() > 4);  //true
        System.out.println("anyMatch----------->" + anyMatch);
        //findFirst（）返回第一个元素
        Optional<Student> findFirst = studentList.stream().findFirst();
        Student findFirstStudent = findFirst.get();
        System.out.println("findFirst----------->" + findFirstStudent.toString());
        //findAny（）返回当前流中的任意元素:串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个。
        Optional<Student> findAny = studentList.stream().findAny();
        Student findAnyStudent = findAny.get();
        System.out.println("findAny----------->" + findAnyStudent.toString());
        //count（）返回流中元素总数
        long count = countList.stream().count();
        System.out.println("count----------->" + count);
        //max（Comparator c）返回流中最大值
        long max = countList.stream().max(Integer::compareTo).get();
        System.out.println("max----------->" + max);
        //min（Comparator c）返回流中最小值
        long min = countList.stream().min(Integer::compareTo).get();
        System.out.println("min----------->" + min);
        //forEach（Consumer c）内部迭代（使用Co11ection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部迭代——它帮你把选代做了）
        //结果
//        allMatch----------->false
//        noneMatch----------->true
//        anyMatch----------->true
//        findFirst----------->Student(num=1, name=Java:mapStudentDemo:mapNameDemopeek)
//        findAny----------->Student(num=1, name=Java:mapStudentDemo:mapNameDemopeek)
//        count----------->9
//        max----------->35
//        min----------->1



        /**
         * 以下为Stream的终止操作的归约
         *
         */
        //reduce（BinaryOperator b）可以将流中元素反复结合起来，得到一个值。返回Optional<T〉
        Optional<Integer> reduce = reduceList.stream().reduce((x1, x2) -> x1 + x2);
        Integer reduceF = reduce.get();
        System.out.println("reduceF----------->" + reduceF);

        //reduce（T iden，BinaryOperator<T> accumulator）可以将流中元素反复结合起来，得到一个值。返回T
        Integer reduceS = reduceList.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println("reduceS----------->" + reduceS);

        //   <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)：
        // 在串行流(stream)中，该方法跟第二个方法一样，即第三个参数combiner不会起作用。
        // 在并行流(parallelStream)中,我们知道流被fork join出多个线程进行执行，
        // 此时每个线程的执行流程就跟第二个方法reduce(identity,accumulator)一样，而第三个参数combiner函数，
        // 则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。
        //(即串行(stream)时，结果与reduceF一致；；；并行流(parallelStream))时，结果为每个流进行第三个参数处理后再返回结果
        //串行
        Integer reduceT = reduceList.stream().reduce(0,
                (x1, x2) -> x1 + x2,//串行流走的是这个
                (x1, x2) ->  x1 * x2);
        System.out.println("reduceT----------->" + reduceT);//84

        //并行
        Integer reduceFo = reduceList.parallelStream().reduce(0,
                (x1, x2) -> x1 + x2,
                (x1, x2) ->  x1 * x2);//并行流走的是这个
        System.out.println("reduceFo----------->" + reduceFo);//1*2*3*5*5*21*35*7=53858750
        //结果
//        reduceF----------->84
//        reduceS----------->94
//        reduceT----------->84
//        reduceFo----------->3858750





        //collect（Collector c）将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Student> collect1 = Stream.of(
                new Student(1, "Java"), new Student(2, "PHP"),
                new Student(3, "Python"), new Student(4, "C/C++"),
                new Student(5, "Java"), new Student(1, "Java")).collect(Collectors.toList());
    }
}
