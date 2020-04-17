package com.JDK8.old.methodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 11:34
 * Description: No Description
 */
public class Demo3 {
    public static void main(String[] args) {
        List<String> citys = Arrays.asList("beijing","shanghai","tianjin","wuhan");
        Collections.sort(citys,(cityParam1,cityParam2)->cityParam1.compareTo(cityParam2));
        citys.forEach((city)-> System.out.println(city));

        //等价的方法引用
        Collections.sort(citys,String::compareToIgnoreCase);
        citys.forEach(System.out::println);
    }
}
