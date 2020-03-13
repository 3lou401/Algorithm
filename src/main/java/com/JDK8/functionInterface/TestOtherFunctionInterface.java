package com.JDK8.functionInterface;

import com.concurrent.ThreadState.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/1 18:38
 * @Desc: java.util.function中有很多函数式接口
 */
public class TestOtherFunctionInterface {
    public static void main(String[] args) {
        TestOtherFunctionInterface test = new TestOtherFunctionInterface();
        // BiConsumer  接收两个参数，没有返回值
        BiConsumer<String ,Integer> biConsumer = (a,b)->{
            System.out.println("姓名是 "+a+"，年龄是 ："+b);
        };
        test.testBiCosum("zhangsan",12,biConsumer);

        //Bifunction ,接收两个参数，返回一个结果
       Teacher teacher =  test.getTeacher("wangLaoshi",45,(tName,tAge) -> new Teacher(tName,tAge));
        System.out.println(teacher.name);

        //BinaryOperator : biFunction特例，传参和返回值类型一样，接收两个参数，返回一个结果
        test.test(13,14,(a,b)->a+b);

        String shortstr =test.testBinary("hello","li",(a,b)->a.length()-b.length());
        System.out.println("shortstr -"+shortstr);

        //BiPredicat ： 接收两个参数，返回一个boolean结果。
        test.testPredicate(13,14,(a,b)->a>b);

        // booleanSupplier
        test.testBooleanSupplier(()->false);

        //Consumer :接收一个参数，没有返回结果


    }
    public void testBiCosum(String a, int b, BiConsumer<String,Integer> biConsumer){
        biConsumer.accept(a,b);
    }

    public Teacher getTeacher(String a, int age, BiFunction<String,Integer,Teacher>biFunction){
        return biFunction.apply(a,age);
    }
    public void test(int a, int b, BinaryOperator<Integer> binaryOperator){
        System.out.println("计算结果是 ：" + binaryOperator.apply(a,b));
    }
    //测试Binary的静态方法
    public String testBinary(String a, String b ,Comparator<String> comparable){
      return  BinaryOperator.minBy(comparable).apply(a,b);
    }

    public void testPredicate(int a, int b, BiPredicate<Integer,Integer> biPredicate){
        if (biPredicate.test(a,b)){
            System.out.println("两个值满足条件");
        }else{
            System.out.println("不满足条件");
        }
    }
    public void testBooleanSupplier(BooleanSupplier booleanSupplier){
        if (booleanSupplier.getAsBoolean()){
            System.out.println("testBooleanSupplier ：结果是真的");
        }else{
            System.out.println("testBooleanSupplier ：结果是假的");
        }
    }


}
class Teacher{
    String name;
    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
