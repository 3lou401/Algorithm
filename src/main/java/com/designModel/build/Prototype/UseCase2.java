package com.designModel.build.Prototype;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/19 16:53
 * @Desc: 采用原型管理器解决多个原型实例
 */
public class UseCase2 {
    public static void main(String[] args) {
        PrototypeManager pm = new PrototypeManager();
        Circle circle = (Circle) pm.get("Circle");
        circle.countArea();
        Square square = (Square)pm.get("Square");
        square.countArea();

    }
}
interface Shape extends Cloneable{
    public Object clone();

    public void countArea();
}

class Circle implements Shape{

    @Override
    public Object clone() {
        Circle res  = null;
        try {
            res = (Circle)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("计算圆的面积: 请输入圆的半径");
        Scanner in = new Scanner(System.in);
        r = in.nextInt();
        System.out.println("圆的面积是 ： "+(3.14 * r * r));
    }
}
class Square implements Shape{

    @Override
    public Object clone() {
        Square res  = null;
        try {
            res =(Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("计算正方形的面积: 请输入边长");
        Scanner in = new Scanner(System.in);
        r = in.nextInt();
        System.out.println("正方形的面积是 ： "+(r * r));
    }
}


//原型管理器
class PrototypeManager{
    private HashMap map = new HashMap();

    public PrototypeManager() {
        map.put("Circle",new Circle());
        map.put("Square",new Square());
    }

    public void add(String key, Prototype prototype){
        map.put(key,prototype);
    }
    //Need Care : 精华
    public Shape get(String key){
        Shape temp = (Shape) map.get(key);
        return (Shape) temp.clone();
    }
}