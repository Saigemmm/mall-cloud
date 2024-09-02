package org.sellers.basic.base.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream可以由数组或集合创建，对流的操作分为两种：
 * 1. 中间操作，每次返回一个新的流，可以有多个。
 * 2. 终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。
 * 特性：
 * 1. stream不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
 * 2. stream不会改变数据源，通常情况下会产生一个新的集合或一个值。
 * 3. stream具有延迟执行特性，只有调用终端操作时，中间操作才会执行。
 */
public class StreamTest {
    private final List<Person> personList = new ArrayList<>();

    public StreamTest() {
        personList.add(new Person("Tom", 8900, 20, "male", "New York"));
        personList.add(new Person("Jack", 7000, 21, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 22, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 23, "female", "New York"));
        personList.add(new Person("Owen", 9500, 24, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 25, "female", "New York"));
    }

    public void streamFindTest() {
        List<Integer> integerList = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        integerList.stream().filter(x -> x > 6).forEach(System.out::println);//遍历输出符合条件的元素
        //Optional类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
        Optional<Integer> findFirst = integerList.stream().filter(i -> i > 5).findFirst();//匹配第一个
        Optional<Integer> findAny = integerList.parallelStream().filter(i -> i > 6).findAny();//匹配任意（适用于并行流）
        boolean anyMatch = integerList.stream().anyMatch(x -> x > 6);
        System.out.println("匹配第一个值：" + (findFirst.isPresent() ? findFirst.get() : ""));
        System.out.println("匹配任意一个值：" + (findAny.isPresent() ? findAny.get() : ""));
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    public void streamFilterTest() {
        List<String> filterList = personList.stream().filter(p -> p.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        filterList.forEach(n -> System.out.println("高于8000的员工姓名：" + n));
    }

    public void streamMaxTest() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        Optional<String> max2 = list.stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //explanation: The above are absolutely same with each other, which has different forms.
        System.out.println("最长的字符串：" + max.get());
    }

    public void streamAdvanceMaxTest() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        /**
         * 自然排序
         */
        Optional<Integer> max = list.stream().max((o1, o2) -> o1 - o2);//approach one
        Optional<Integer> max2 = list.stream().max(Comparator.comparing(o -> o));//approach two
        Optional<Integer> max3 = list.stream().max((i1, i2) -> i1.compareTo(i2));//approach three, deliberately;
        Optional<Integer> max4 = list.stream().max(Integer::compareTo);//approach four
        /**
         * 自定义排序
         * 上述4种形式的展开
         */
        Optional<Integer> customMax = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//                return o1.compareTo(o2);
                return Integer.compare(o1, o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + customMax.get());
        Optional<Person> personMax = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + (personMax.isPresent() ? personMax.get().getSalary() : " "));
        //count测试，min同理
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }

    /**
     * 映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap
     * --不做演示
     */

    /**
     * 收集(collect),主要依赖java.util.stream.Collectors类内置的静态方法。
     * 1, 归集(toList/toSet/toMap)，--不做演示
     * 2, 统计(count/averaging)
     * 3, 分组(partitioningBy/groupingBy)
     * (1), 分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
     * (2), 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     * 4, 结合，joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。--不做演示
     * 5，归约，Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持。--不做演示
     */
    public void streamCollectTest() {
        // 求总数
        Long count = personList.stream().filter(o -> o.getSalary() > 8000).collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
    }

    /**
     * 排序，two approaches
     * 1. sorted()：自然排序，流中元素需实现Comparable接口
     * 2. sorted(Comparator com)：Comparator排序器自定义排序
     */
    public void streamSortTest() {
        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> p1.getSalary() == p2.getSalary() ? p2.getAge() - p1.getAge() : p2.getSalary() - p1.getSalary()).map(Person::getName).collect(Collectors.toList());
    }

    /**
     * 提取/组合
     * 流也可以进行合并、去重、限制、跳过等操作。
     */
    public void streamExtractTest() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> newList2 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> newList3 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());
    }
}
