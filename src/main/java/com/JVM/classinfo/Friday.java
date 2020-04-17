package com.JVM.classinfo;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/26
 * Time: 19:01
 * Description:
 */
public class Friday {
    private String name;
    public String desc;
    public int age;
    private long num;
    protected  boolean isA;
    protected final int score;
    private   final static int ssh = 0;

    public Friday() {
        score = 0;
    }


    public int getI(){
        return 12;
    }

    private String show(){
        return "hello";
    }
    public static void main(String[] args) {
        float s = 13.1f;
        float s2 = 13.9f;

        int si1 = Math.round(s); //13
        int si2 = Math.round(s2); //14

        System.out.println(si1 +"-"+si2);



    }

    static class InnerShow{
        protected String add;
    }
}
