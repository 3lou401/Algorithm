package com.designModel.Structure.Decoractor;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 20:20
 * @Desc: 装饰者模式 ：
 *      目的对不改变现有对象的前提下扩展系统功能
 *      主要角色 ： 具体构件（系统当前存在的构件）
 *              &   抽象构件 （对具体构件抽象，以便规范具体装饰者）
 *              &   抽象装饰者 （聚合抽象构件，实现抽象构件）
 *              &   具体装饰者
 *
 */
public class PackageInfo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new ConcreteDecorator(component);
        Component decorator1 = new ConcreteDecorator2(decorator);
        decorator1.oper();
    }
}
interface  Component{
    public void oper();
}
class ConcreteComponent implements Component{
    @Override
    public void oper() {
        System.out.printf("这是具体的构件。。。\n");
    }
}
abstract class Decorator implements Component{
    protected Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    public abstract void oper() ;
  }
  class ConcreteDecorator extends Decorator{
      public ConcreteDecorator(Component component) {
          super(component);
      }
      @Override
      public void oper() {
        component.oper();
        addedFunc();
      }
      public  void addedFunc(){
          System.out.printf("扩展的功能...\n");
      }
  }
  class ConcreteDecorator2 extends Decorator{
      public ConcreteDecorator2(Component component) {
          super(component);
      }

      @Override
      public void oper() {
          component.oper();
          addedFunc();
      }
      public  void addedFunc(){
          System.out.printf("新扩展的功能...\n");
      }
  }