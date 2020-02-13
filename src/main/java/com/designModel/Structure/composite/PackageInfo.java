package com.designModel.Structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/13 10:08
 * @Desc: 合成模式 ： 用意， 处理“整体-部分”关系， 设计成树结构，使得客户端对于树枝和树叶有一致性的访问
 *                  角色 ： 抽象构件 & 树枝构件（聚合抽象构件） & 树叶构件
 *              输出结果 ： 调用root.oper()会遍历整个树结构
 *
 正在访问树枝构件...
正在访问树叶构件 根节点的第一个儿子
正在访问树叶构件 根节点的第二个儿子
正在访问树叶构件 根节点的第三个儿子
正在访问树枝构件...
正在访问树叶构件 rootComposite节点的第一个儿子
正在访问树叶构件 rootComposite节点的第一个儿子
正在访问树枝构件...
正在访问树叶构件 rootCompComp节点的第一个儿子
正在访问树叶构件 rootCompComp节点的第二个儿子
 */
public class PackageInfo {
    public static void main(String[] args) {
        //树结构的组织，这里先暂时整理一个三层结构，测试
        Composite root = new Composite(); // 根节点 - 树枝节点
        Component rootLeaf1 = new Leaf("根节点的第一个儿子");
        root.add(rootLeaf1);
        Component rootLeaf2 = new Leaf("根节点的第二个儿子");
        root.add(rootLeaf2);
        Component rootLeaf3 = new Leaf("根节点的第三个儿子");
        root.add(rootLeaf3);
        Composite rootComposite = new Composite();
        root.add(rootComposite);

        Component rootCompositeLeaf1 = new Leaf("rootComposite节点的第一个儿子");
        rootComposite.add(rootCompositeLeaf1);
        Component rootCompositeLeaf2 = new Leaf("rootComposite节点的第二个儿子");
        rootComposite.add(rootCompositeLeaf1);
        Composite rootCompComp = new Composite();
        rootComposite.add(rootCompComp); // 根节点上添加一个树枝节点

        Component rootCompCompLeaf1 = new Leaf("rootCompComp节点的第一个儿子");
        rootCompComp.add(rootCompCompLeaf1);
        Component rootCompCompLeaf2 = new Leaf("rootCompComp节点的第二个儿子");
        rootCompComp.add(rootCompCompLeaf2);

        root.oper();

    }
}
abstract  class Component {
   abstract void oper();
}

class Leaf extends Component {
    private  String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    void oper() {
        System.out.printf("正在访问树叶构件 "+name+"\n");
    }
}
class Composite extends Component{
    private List<Component> components = new ArrayList<>();

    public void add(Component component){
        components.add(component);
    }
    public void remove(Component c){
        components.remove(c);
    }
    public Component getChild(int index){
        return components.get(index);
    }

    @Override
    void oper() {
        //遍历其拥有的树叶
        System.out.printf("正在访问树枝构件...\n");
        for (Component c : components){
            c.oper();
        }
    }
}