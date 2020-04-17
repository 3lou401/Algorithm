package com.JDK8.Stream.grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 12:56
 * Description: 对数组进行分组和分区
 */
public class Test1 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",89);
        Student s2 = new Student("lis",72);
        Student s3 = new Student("wangwu",72);
        Student s4 = new Student("zhangsan",89);

        List<Student> students = Arrays.asList(s1,s2,s3,s4);

        Map<String,List<Student>> map =
                students.stream().collect(Collectors.groupingBy(student -> student.getName()));
        System.out.println(map);

       Map<Integer,Long> res =
               students.stream().collect(Collectors.groupingBy(stu->stu.getScore(),Collectors.counting()));

       Map<Integer,Double> res2 =
               students.stream().collect(Collectors.groupingBy(stu->stu.getScore(),Collectors.averagingLong(stu->stu.getScore())));
    }
}
