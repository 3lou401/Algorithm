package com.JDK8.Stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 12:02
 * Description: 测试串行和并行流 已排序为例， 处理耗时
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);
        for(int i=0;i<5000000;i++){
            list.add(UUID.randomUUID().toString());
        }
        long start = System.nanoTime();

        list.stream().sorted().count(); // 串行流 4 2059 6500
//        list.parallelStream().sorted().count(); // 并行流 2 6147 9001

        long end = System.nanoTime();
        System.out.println("耗费时间(毫秒)："+ TimeUnit.MILLISECONDS.toMillis(end-start));
    }
}
