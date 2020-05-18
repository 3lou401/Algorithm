package MyTest;

import java.time.OffsetDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/5/2
 * Time: 13:19
 * Description: 解析地址的  /根目录   ../父目录  ./ 当前目录
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        String oldP = "";
        String path = test1.simplifyPath(oldP);
    }

    private String simplifyPath(String originpath){
        //采用双端队列
        Deque<Character> deque = new LinkedList<>();
        //字符串转byte[],for循环处理
        byte[] op = originpath.getBytes();
        for(byte b : op){
            //如果是/ 判断上一个和上上一个是不是.
            if (b == '/' ){
                char b1 = deque.pop();
                if (b1 == '.'){
                    char b2 = deque.peek();
                    if (b2 =='.'){
                        // ../的形式
                        deque.pop(); //弹出.
                        while (deque.peek() != '/'){
                            deque.pop();
                        }
                    }else {
                        // ./的形式 不需要入栈
                    }
                }else {
                    //上一个不是 . 直接入栈
                    deque.push((char) b);
                }
            }else if ( Character.isLetter(b) || b =='.'){
                //判断上一个是不是点
                deque.push((char) b);
            }
        }
        //从deque队尾出
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.removeLast());
        }
        return sb.toString();
    }
}
