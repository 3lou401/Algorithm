package com.designModel.active.VisitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/14
 * Time: 14:55
 * Description: 比如一个打印方法，需要判断集合元素进行打印，改为访问者模式
 */
public class UseCase2 {
}

//不合适代码
class Old{
    List<Object> list = new ArrayList<>();

    public void print (){
        for (Object obj : list){
            if (obj instanceof  String){
                System.out.println("-"+obj.toString());
            }else if (obj instanceof  Integer){
                System.out.println(obj+"-integer");
            }else if (obj instanceof  Double){
                System.out.println(obj+"Double");
            }
            //...
        }
    }

}

class NewList{
    List<MyElement> ele = new ArrayList<>();
    public void print(VisitorUc visitorUc){
        for (MyElement obj:ele){
            obj.accept(visitorUc);
        }
    }
}
 abstract  class MyElement{
    abstract void accept(VisitorUc visitorUc);
}
class  StringElement extends MyElement {
    @Override
    void accept(VisitorUc visitorUc) {
        visitorUc.accept(this);
    }
}
class  IntegerElement extends MyElement {
    @Override
    void accept(VisitorUc visitorUc) {
        visitorUc.accept(this);
    }
}

//暂时只要一个访问者，省略抽象访问角色
class VisitorUc{
    void accept(StringElement stringElement){
        System.out.println(stringElement+"String");
    }
    void accept(IntegerElement integerElement){
        System.out.println(integerElement+"Integer");
    }
}