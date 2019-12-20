package com.dataStructure;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/14 12:37
 * @Desc:  利用所学的数据结构，表示一个多项式，并实现加法 ，如7x^5 - 2x^2 + 8x + 1
 * 解析 ： 需要存储的就是系数和指数，因此可以采用下边的方式
 */
public class UseCase {
}
// 采用数组存储，下标表示指数， 下标存储的值表示 系数
class Solution1 {

   //上边的多项式，可以表示成如下的方式
   public double[] show(){
       double [] a  = new double[6];
       a[0] = 1;
       a[1] = 8;
       a[2 ] = -2;
       a[3] = 0;
       a[4] = 0;
       a[5] = 7;
       return a;
   }
   //加法简单，只需对应下标的相加即可
    public double[] add(double [] a,double[]b){
       int length = Math.min(a.length,b.length);
       int alen = Math.max(a.length,b.length);


       double [] res = new double[alen];
       for(int i = 0; i < length;i++){
            res[i] = a[i]+b[i];
       }
       double [] n;
       if (a.length > b.length)
           n =a;
       else
           n =b;
       for(int j = length;j < alen;j++){
           res[j] = n[j];
       }
       return res;
    }


}


//上边的缺点， 如果多项式比较稀疏，比如 5x^1000 , 上边的方式，需要1000个存储空间，很浪费
//方式2 ，只存储非0项 ， 比如 [{5,7},{2,-2},{1,8},{0,1}]
class Solution2{
    private class Node{
        int zhishu;
        double xishu;

        public Node(int zhishu, double xishu) {
            this.zhishu = zhishu;
            this.xishu = xishu;
        }
    }
    //表示上边的例子
    public Node[] show(){
        Node[] res = new Node[4];// 注意，只存储非0项


        res[0] = new Node(0,1);
        res[1] = new Node(1,8);
        res[2] = new Node(2,-2);
        res[3] = new Node(5,7);
        return res;
    }
    //加法复杂一点，循环两个数组，比较指数
    public Node[] add(Node[] a, Node[] b){
        //最差情况下，没有一个指数相同的，那么新数组的大小实际上是两个数组的长度之和
        Node[] res = new Node[a.length+b.length];
        int i=0,j=0,resK = 0;
        while (i < a.length  && j < b.length){
                int ret = a[i].zhishu - b[j].zhishu;
                if (ret == 0){
                    res[resK++] =  new Node(a[i].zhishu, a[i].xishu + b[j].xishu);
                    i++;
                    j++;
                }else if (ret > 0){
                    res[resK++] =  new Node(a[i].zhishu, a[i].xishu );
                    i++;
                }else {
                    res[resK++] =  new Node(b[j].zhishu,  b[j].xishu);
                    j++;
            }
        }
        while (i < a.length){
            res[resK++] =  new Node(a[i].zhishu, a[i].xishu );
            i++;
        }
        while (j < b.length){
            res[resK++] =  new Node(b[j].zhishu,  b[j].xishu);
            j++;
        }
        return res;
    }

    //多项式乘法 A * B ， A中第一项*B + 第二项*B + ...最后一项*B (利用辅助链表)
    //系数相乘 ，指数相加
    public Node[] multi(Node[]a ,Node[]b){
        Node [] temp1 = new Node[99];
        Node [] temp2 = new Node[99];

        // A的第一项 * B
        int countA = 0;
        for(int i = 0; i < b.length;i++){
             temp1[i] = new Node( a[0].zhishu+b[i].zhishu,a[0].xishu * b[i].xishu);
        }
        countA = 1;

        // A的第二项* B
        while (countA < a.length){
            for(int i = 0; i < b.length;i++){
                temp2[i] = new Node( a[countA].zhishu+b[i].zhishu,a[countA].xishu * b[i].xishu);
            }
            temp1 = add(temp1,temp2);
            countA++;
        }
        return temp1;
    }

}

//采用链表的方式，如 P = 12x^9 + 7x^5-4x^2 ; 通常是指数从高到低排列
class Solution3{
    private class Node{
        int zhishu;
        double xishu;
        Node next;

        public Node(int zhishu, double xishu,Node next) {
            this.zhishu = zhishu;
            this.xishu = xishu;
            this.next = next;
        }
    }
    Node begin;
    int length;
    // 9/12 ---> 5/7 --->  2/-4
    public void show(){
        addFirst(2,-4);
        addFirst(5,7);
        addFirst(9,12);
    }
    private void addFirst(int zhishu, double xishu){
        final Node  f = begin;
        Node temp = new Node(zhishu,xishu,f);
        begin = temp;
        if (f ==null)
            length = 1;
        else
            length++;
    }
    private void addLast(int zhishu, double xishu){
        Node prev = begin,temp = begin;
        while (temp != null){
            prev = temp;
            temp = temp.next;
        }
        Node newNode = new Node(zhishu,xishu,null);
        if (prev == null){
            begin = newNode;
            length = 1;
        }else {
            prev.next = newNode;
            length++;
        }
    }
    // 多项式相加 Solution3 相当于是多项式了
     public static Solution3 add(Solution3 s1,Solution3 s2){
        Solution3 res = new Solution3();
        Node s1N = s1.begin;
        Node s2N = s2.begin;
        while (s1N != null && s2N != null ){
                int ret = s1N.zhishu - s2N.zhishu;
                if (ret ==0 ){
                    res.addLast(s1N.zhishu,(s1N.xishu+s2N.xishu));
                    s1N = s1N.next;
                    s2N = s2N.next;
                }else if(ret > 0){
                    res.addLast(s1N.zhishu,s1N.xishu);
                    s1N = s1N.next;
                }else {
                    res.addLast(s2N.zhishu,s2N.xishu);
                    s2N = s2N.next;
                }
        }

        while (s1N != null){
            res.addLast(s1N.zhishu,s1N.xishu);
            s1N = s1N.next;
        }
        while (s2N != null){
            res.addLast(s2N.zhishu,s2N.xishu);
            s2N = s2N.next;
        }
        return res;
     }


    //5x8 + 4x3 + 2x +2
    //12x9-7x8+4x3+1
    public static void main(String[] args) {
        System.out.println("开始");
        Solution3 a = new Solution3();
//        Anti_Polish.addFirst(0,2);
//        Anti_Polish.addFirst(1,2);
//        Anti_Polish.addFirst(3,4);
        a.addFirst(8,5);



        a.addFirst(10,10);
        a.addFirst(11,2);
        a.addFirst(13,2);
        a.addFirst(17,2);
        Solution3 b = new Solution3();
        b.addFirst(0,1);
        b.addFirst(3,4);
        b.addFirst(8,-7);
        b.addFirst(9,12);
        Solution3 c = add(a,b);
        System.out.printf("结果 ： "+c.length);
    }

}