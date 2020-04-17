package com.java.showReflect;

import java.lang.reflect.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/2
 * Time: 22:14
 * Description: 分析Class的特性，比如Field Method Constructor
 */
public class Test3 {
    public static void main(String[] args) {

        //设分析类为 java.util.Date
        Date date = new Date();
        Class c = date.getClass();
        printFieldInfo(c);


    }

    /**
     * 该构造方法 public java.util.Date (
     *  int arg0 ,  int arg1 ,  int arg2 ,  int arg3 ,  int arg4 ,  int arg5 )
     * @param c1
     */
    private static void printConstructorInfo(Class c1){
        Constructor [] constructors = c1.getConstructors();

        for(Constructor constructor : constructors){
//            System.out.printf("该构造方法 "+ Modifier.toString(constructor.getModifiers()));
//            System.out.printf(" "+constructor.getName());
//            System.out.println(" ( ");
//            //参数信息
//            Parameter[] parameters = constructor.getParameters();
//            for(int i = 0; i < parameters.length;i++){
//                Parameter parameter = parameters[i];
//                if (i > 0)
//                    System.out.printf(" , ");
//                System.out.printf(" "+parameter.getType()+" "+parameter.getName());
//            }
//            System.out.println(" ) ");
//            System.out.println();

            //下边的代码直接打印构造方法信息
            System.out.println(constructor.toString());
        }

    }
    private static void printMethodInfo(Class c1){
        Method [] methods = c1.getMethods();
        for (Method method: methods){
            System.out.printf("该方法 "+Modifier.toString(method.getModifiers()));
            System.out.printf(" "+method.getReturnType().getName());
            System.out.printf(" "+method.getName());
            System.out.printf(" ( ");
            Parameter [] parameters = method.getParameters();
            for (int i =0; i<parameters.length;i++){
                if (i > 0)
                    System.out.printf(" , ");
                Parameter parameter = parameters[i];
                System.out.printf(""+parameter.getType());
                System.out.printf(" "+parameter.getName());
            }
            System.out.printf(" ) ");
            System.out.println();
        }
    }
    private static void printFieldInfo(Class c1){
        Field[] fields = c1.getDeclaredFields();
        for(Field field :fields){
            System.out.println("该字段 "+ Modifier.toString(field.getModifiers())
                        +" "+field.getType()+" "+field.getName()
            );
            //可以直接使用toString打印信息
//            System.out.println(field.toString());
        }
    }
}
