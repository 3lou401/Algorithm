package com.JDK8.showlambda;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/10
 * Time: 17:34
 * Description: lambda表达式中使用外部变量
 */
public class Test4 {
    public static void main(String[] args) {

        //1  匿名内部类中可以使用外部变量否？

        //2.lambda表达式中可以直接使用外部变量，但是出于并发考虑，外部变量在外部不可变
        print("outer",12); //字符串outer并不是lambda表达式中定义的变量，但却可以直接使用

        //测试一下，直接使用外部可变变量
        print2("haha",13);
        for (int i = 0;i<4;i++){
            print2("oak",i);
        }




        //测试一下直接在for循环使用可变外部变量 ,
       /* for (int k = 0;k < 5;k++){
            MyInterface3 myInterface3 = a-> {
                System.out.println(a);
                System.out.println(k);//发现编译器报错
            };
            myInterface3.method("bbb");
        }*/
        //修改
        for (int k = 0;k < 5;k++){
            final int t = k;
            MyInterface3 myInterface3 = a-> {
                System.out.println(a);
                System.out.println(t);
            };
            myInterface3.method("bbb");
        }
    }
    public static void print(String text,int key){
        MyInterface2 myInterface2 = a->{
            System.out.println("函数式接口中传参-"+a);
            System.out.println("可以直接使用外部变量-"+text);
        };
        myInterface2.method(key);
    }
    public static void print2(String text,int key){
        MyInterface3 myInterface3 = a->{
            System.out.println("函数式接口中传参-"+a);
            System.out.println("可以直接使用外部变量-"+key);
        };
        myInterface3.method(text);
    }


}

@FunctionalInterface
interface  MyInterface2{
    void method(int num);
}

@FunctionalInterface
interface  MyInterface3{
    void method(String str);
}
