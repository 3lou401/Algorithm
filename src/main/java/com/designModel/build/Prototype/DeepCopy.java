package com.designModel.build.Prototype;

import java.io.*;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/19 21:41
 * @Desc:
 */
public class DeepCopy {
    public static void main(String[] args) {
        PrototypeD pd = new PrototypeD();
        PrototypeD pd1 = (PrototypeD) pd.clone();
        System.out.println("测试 浅copy ");
        System.out.println("pd == pd1 : "+ (pd == pd1) );
        System.out.println("类中对象的引用 ： pd.pdr == pd1.pdr : "+ (pd.getPdr() == pd1.getPdr()) );

        PrototypeD pd2 = (PrototypeD) pd.deepClone();
        System.out.println("测试 深copy ");
        System.out.println("pd == pd2 : "+ (pd == pd2) );
        System.out.println("类中对象的引用 ： pd.pdr == pd2.pdr : "+ (pd.getPdr() == pd2.getPdr()) );
    }
}
class PrototypeD implements Cloneable,Serializable{
    private ProtoDRefer pdr ;
    private int age;
    public ProtoDRefer getPdr() {
        return pdr;
    }
    public PrototypeD() {
        pdr = new ProtoDRefer("lisi");
        age = 13;
    }
    public Object deepClone(){
        Object res  = null;
        try {
            //先写入流中
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //再从流中读出
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            res =  ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Object clone(){
        Object res = null;
        try {
            res = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }

}
class ProtoDRefer implements  Serializable{
    private String name;

    public ProtoDRefer(String name) {
        this.name = name;
    }
}