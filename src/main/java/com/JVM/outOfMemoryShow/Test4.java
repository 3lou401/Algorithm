package com.JVM.outOfMemoryShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 22:58
 * Description: No Description
 * vm args : -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class Test4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
