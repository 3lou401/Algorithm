package com.JDK8.Stream.baseinfo;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 9:32
 * Description: generate
 */
public class Test5 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.generate(UUID.randomUUID()::toString);
        stringStream.findFirst().ifPresent(System.out::println);
    }
}
