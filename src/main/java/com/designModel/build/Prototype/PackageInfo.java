package com.designModel.build.Prototype;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/19 12:07
 * @Desc: 原型复制模式  直接使用对象原型通过复制创建类似对象
 *              分类 ： 深克隆，浅克隆
 *              实现方式  implement Cloneable  &  实现clone方法
 *                          Cloneable只是一个声明式接口
 */
public class PackageInfo {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(12);
        cp.setName("李四");
        ConcretePrototype cp2 = (ConcretePrototype) cp.clone();
        System.out.println(""+cp2);
        System.out.println("测试是否未同一个对象 ："+(cp == cp2));
        System.out.println("测试equals ："+(cp.equals(cp2)));
    }
}

//方式一 ： 角色 抽象原型 & 具体原型
interface  Prototype extends Cloneable{
     public Object clone() throws CloneNotSupportedException;
}

class ConcretePro1 implements Prototype{

    @Override
    public Object clone()  throws  CloneNotSupportedException{
        return super.clone();
    }
}


// 方式二 ：直接省略抽象原型角色
class ConcretePrototype implements Cloneable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object clone()  {
//        ConcretePrototype c1 = new ConcretePrototype();
//        c1.age = this.age;
//        c1.name = this.name;
//        return c1;
        Object res = null ;
        try {
            res = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }
}