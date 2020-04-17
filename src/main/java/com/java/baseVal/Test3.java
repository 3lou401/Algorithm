package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 12:50
 * Description: 小心浮点数
 *
 */
public class Test3 {
    public static void main(String[] args) {
//        for (double x = 5; x< 6; x+=0.1){
//            System.out.println("--"+x);
//        }
        /**
         * --5.299999999999999
         * --5.399999999999999
         * --5.499999999999998
         * --5.599999999999998
         * --5.6999999999999975
         * --5.799999999999997
         * --5.899999999999997
         * --5.9999999999999964
         */
//        错误写法 会无限执行下去

//        for(double x= 5; x != 6; x+=0.1){
//            System.out.println("--"+x);
//        }
//        若条件就是循环到等于浮点值 d1
        double d1 = 6.1;
        for (double x = 5; x  < d1  ;x+=0.1){
            System.out.println("--"+x);

        }
    }
}
