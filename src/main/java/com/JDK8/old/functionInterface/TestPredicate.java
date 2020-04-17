package com.JDK8.old.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/27 18:01
 * @Desc:
 */
public class TestPredicate {
    public static void main(String[] args) {
        Predicate<String> predicate = p->p.length() > 0;
        System.out.println(""+predicate.test("hello"));

        /** and or 都是Predicate的default方法*/
        // and
        int a = 9;
        System.out.println("大于5并且整除3 " + testAnd(a  ,  x->x > 5, y->y%3 ==0  ) );

        //or
        String s = "he1llo worrld";
        System.out.println("字符串中包含hello 或者包含world "+testOr(s, x->x.contains("hello"), x->x.contains("world")));



        /** 测试 静态方法**/
        // isEqual 是静态方法，可以直接用接口调用，不需要实例
        System.out.println("" + Predicate.isEqual("hello").test("hello"));

        //取反
        List<String> stringList = Arrays.asList("a","bcd","ef","h");
        testNegate(stringList,e->e.length()>2);


    }

    public  static  void testNegate(List<String>  slist ,Predicate<String> p1){
        for(String s : slist){
            if (p1.negate().test(s)){
                System.out.println(s+"-");
            }
        }
    }
    public static boolean testAnd(int a, Predicate<Integer> predicate1, Predicate<Integer> b){
        return predicate1.and(b).test(a);
    }

    public  static  boolean testOr(String s ,Predicate<String> p1,Predicate<String> p2){
        return p2.or(p1).test(s);
    }

}
