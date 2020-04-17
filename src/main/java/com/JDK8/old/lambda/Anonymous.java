package com.JDK8.old.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/22 17:18
 * @Desc: 为什么使用Lambda， 匿名函数 和匿名类 写法不方面，语法优化
 *
 */
public class Anonymous {
    public static void main(String[] args) {
        System.out.println("再举一个例子，list.foreach");
        List<Integer> list = new ArrayList<>();
        //先初始化
        for (int i=0;i < 5;i++){
            list.add(i);
        }
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //替换为Lambda
        System.out.println("other foreach");
        list.forEach(integer-> System.out.println(integer));
    }
}
class SwingTest{
    public static void test1() {
        System.out.println("hello");
        JFrame jFrame = new JFrame("my frame");
        JButton jButton = new JButton("my button");

        //使用匿名内部类给button添加点击事件
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击事件触发了");
            }
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 上边的匿名函数中，IDEA 提示可以替换为Lambda表达式
    public static void test2() {
        System.out.println("hello");
        JFrame jFrame = new JFrame("my frame");
        JButton jButton = new JButton("my button");

        //使用匿名内部类给button添加点击事件
        jButton.addActionListener(e -> System.out.println("点击事件触发了"));
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //替换之后，发现匿名内部类 实现变成了 e -> System.out.println("点击事件触发了")
    // 简单看 ，分三部分  参数  lambda表达式（->）  对应函数体
    // 思考 ： 多个方法的抽象接口，无法改成Lambda表达式形式
    // 思考 ： 参数不需要指定类型， jdk8 编译系统有时 可以自己推断是什么类型 ，如果推断不出来，需要显示指定

    //自己写个测试
    public static void test3() {
        System.out.println("hello");
        JFrame jFrame = new JFrame("my frame");
        JButton jButton = new JButton("my button");

        //使用匿名内部类给button添加点击事件
        jButton.addActionListener(event ->{
            System.out.println("button pressed");
            System.out.println("按钮被点击了");
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //        test1();
    }

}



