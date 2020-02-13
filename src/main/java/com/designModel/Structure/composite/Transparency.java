package com.designModel.Structure.composite;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/13 10:39
 * @Desc: 透明式的合成模式
 *        唯一的区别是 将处理树叶构件的方法上提到抽象构件中
 *        客户端创建时，因为是透明的，所以都是Component
 */
public class Transparency {
    public static void main(String[] args) {
        ComponentTrans root = new CompositeTrans();

        ComponentTrans leaf1 = new LeafTrans("root第一个儿子");
        ComponentTrans leaf2 = new LeafTrans("root第一个儿子");
        root.add(leaf1);
        root.add(leaf2);
        ComponentTrans composite = new CompositeTrans();
        root.add(composite);

        ComponentTrans comLeaf1 = new LeafTrans("composite的第一个儿子");
        ComponentTrans comLeaf2 = new LeafTrans("composite的第二个儿子");
        composite.add(comLeaf1);
        composite.add(comLeaf2);

        root.oper();
    }
}
abstract class ComponentTrans{
    abstract void add(ComponentTrans c);
    abstract void remove(ComponentTrans c);
    abstract void getChild(int index);
    abstract void oper();
}

//树叶构件

class LeafTrans extends ComponentTrans{
    private String name;

    public LeafTrans(String name) {
        this.name = name;
    }

    @Override
    void add(ComponentTrans c) {
        throw  new NotImplementedException();
    }

    @Override
    void remove(ComponentTrans c) {
        throw  new NotImplementedException();
    }

    @Override
    void getChild(int index) {
        throw  new NotImplementedException();
    }

    @Override
    void oper() {
        System.out.printf("树叶构件 "+name+" ...\n");
    }
}

class CompositeTrans extends ComponentTrans{
    private List<ComponentTrans> componentTrans = new ArrayList<>();
    @Override
    void add(ComponentTrans c) {
        componentTrans.add(c);
    }

    @Override
    void remove(ComponentTrans c) {
        componentTrans.remove(c);
    }

    @Override
    void getChild(int index) {
        componentTrans.get(index);
    }

    @Override
    void oper() {
        for (ComponentTrans c: componentTrans){
            c.oper();
        }
    }
}

