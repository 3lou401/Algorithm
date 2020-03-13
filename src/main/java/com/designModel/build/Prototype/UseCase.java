package com.designModel.build.Prototype;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/19 16:24
 * @Desc: 拿奖状为例，对象都相似，比如学校 信息相同， 不同的是姓名
 */
public class UseCase {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation zS  = new Citation("张三","三好学生","武汉小学");

        System.out.println(""+zS);
        Citation lS = (Citation) zS.clone();
        lS.setName("李四");
        System.out.println(""+lS);
    }
}

class Citation implements Cloneable{
    private String name;

    private String info;

    private String colleage;

    public void setName(String name) {
        this.name = name;
    }

    public Citation(String name, String info, String colleage) {
        this.name = name;
        this.info = info;
        this.colleage = colleage;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", colleage='" + colleage + '\'' +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
