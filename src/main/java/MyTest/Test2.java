package MyTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/5/2
 * Time: 13:44
 * Description:  第一个是 数字 ， 第二个是输入的行数，中间空格分隔， A- > B , A依赖于B,
 *                找出最大依赖
 */
public class Test2 {
    static class Pac {
        String name;
        Pac parent;
        int num = 0; //儿子和孙子个数 ,初始值为0

        public Pac(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        HashMap<String,Pac> map = new HashMap<>();
        for (int i=0;i < num;i++){
            String  str = scanner.nextLine();
            String [] strings = str.split(" ");
            //可能存在重复的
            String key0 = strings[0];
            Pac son,parent;
            if (map.containsKey(key0)){
                son = map.get(key0);
            }else {
                 son = new Pac(strings[0]);
            }
            String key1 = strings[1];
            if (map.containsKey(key1)){
                parent = map.get(key1);
            }else {
                parent = new Pac(key1);
            }
//            son.parent = par;
        }
        //记录好 所有的对象及其父亲，统计
        for(Map.Entry<String,Pac> entry : map.entrySet()){
            Pac pac = entry.getValue();
            if (pac.parent != null){
                pac.num = pac.num == 0? 1:pac.num;
                pac.parent.num += pac.num;
            }
        }

        // 根据儿子个数排序

        //选择出最大的那个

    }
}
