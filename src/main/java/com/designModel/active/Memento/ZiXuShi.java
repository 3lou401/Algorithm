package com.designModel.active.Memento;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/2 15:16
 * @Desc: 没有管理者的黑箱备忘录
 */
public class ZiXuShi {
    public static void main(String[] args) throws CloneNotSupportedException {
        OriginatorZXS originatorZXS = new OriginatorZXS();
        originatorZXS.setStudentZXS(new StudentZXS("lisi"));
        MementoZIF mementoZIF = originatorZXS.createMemento();
        //修改状态
        originatorZXS.setStudentZXS(new StudentZXS("wangwu"));
        System.out.println("当前状态 ："+originatorZXS.getStudentZXS().getName());
        //恢复
        originatorZXS.restoreStu(mementoZIF);
        System.out.println("当前状态 ："+originatorZXS.getStudentZXS().getName());

    }
}
//发起者
class OriginatorZXS{
    private StudentZXS studentZXS;
    public StudentZXS getStudentZXS() {   return studentZXS;  }
    public void setStudentZXS(StudentZXS studentZXS) {   this.studentZXS = studentZXS;  }
     public MementoZIF createMemento() throws CloneNotSupportedException {
        StudentZXS newStu = this.studentZXS.clone();
        return new MementoZ(newStu);
     }
     //还原
    public void restoreStu(MementoZIF mementoZIF) throws CloneNotSupportedException {
        MementoZ mementoZ = (MementoZ) mementoZIF;
        this.studentZXS = mementoZ.getStu().clone();
    }
     class MementoZ implements MementoZIF{
        private StudentZXS stu;
         public MementoZ(StudentZXS stu) {      this.stu = stu;        }
         public  StudentZXS  getStu(){        return stu;         }
     }
}
//黑箱备忘录角色
interface MementoZIF{}

//这次保存一个对象的测试, 测试点在于 对象的备份是需要clone
class StudentZXS implements Cloneable{
    private String name;
    public StudentZXS(String name) {this.name = name;}
    public String getName() { return name; }

    @Override
    protected StudentZXS clone() throws CloneNotSupportedException {
        return (StudentZXS)super.clone();
    }
}
