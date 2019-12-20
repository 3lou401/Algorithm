package com.dataStructure;

import java.util.*;
import java.util.logging.Level;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/20 15:16
 * @desc:
 */
public class TreeDefine {
    //当数据具有有序性，基于线性表的二叉查找算法复杂度O(logN) ,当数据没有有序性时

}

//树的定义 ： 是n（n>=0）个节点组成的集合，n=0时是空树 ，
// 这个集合的特点： 1.有一个称为"树根"的节点； 2.其他节点分为m个"不相交"的子集, 每个子集又是一棵树
// 树的定义采用 ：递归的形式
// 树可以表示为一个二元组  Tree =(root,forest),root是根节点，forest是各个子树构
// 树的概念 ：
//1. 节点的度 ： 节点的子树个数
//2. 节点的层：根节点是一层，其他节点层是其父节点层+1
//3. 树的深度： 节点的最大层数就是树的深度， 举例，只有根节点，深度为1，右儿子 深度+1
//4. 树的高度： 和深度类似，不同在于自底向上，儿子是1，父亲是儿子的高度最大值+1
abstract  class Tree<T>{
    T root;
    Tree son1,son2,son3; //....可能会更多
}


// 二叉树 ： 父亲最多拥有左右两棵子树，这里具体一下，
// Node表示节点，BTree从根节点入手（root），通过root可达任意节点
abstract  class BTree<T>{
    private class Node<T>{
        Node<T> left,right;
        T value;
    }
    Node<T> root; //根节点
}
// 二叉树概念
//1. N个节点二叉树，最坏深度是O(N)-斜二叉树,最佳深度是O(logN)-满二叉树或完美二叉树 平均深度是O（sqrt(N)）
//2. 完全二叉树，叶子节点只可能出现在最下层和次下层

//二叉树性质
//1. 第i层的节点数，最多是2^{i-1}
//2. 深度为k的二叉树，最多有2^k -1个节点 ，同理n个节点的二叉树深度是logN+1
//3. 设N0表示度为0的节点个数，N2表示度为2的节点个数， N0= N2 + 1 (叶子节点个数之和 = 有两个儿子节点个数之和+1)
//证明 总结点数设为N,边数设为B ,则 B = N -1 ,
// 同时B=N1+2*N2 , 得出N = N1+2*N2+1, 同时节点数N=N0+N1+N2,
class BinaryTree<T> {
    private class Node<T>{
        public Node(Node left, Node right, T value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node() {
        }

        Node<T> left, right; T value; }

        Node<T> root;

      /**
       * 根据层序数组生成二叉树
        * @param [datas] 是按照层序组织的树的所有数据 ； 利用队列
        * @desc        // 1. 先取出一个树，作为根，入队列
       *             // 2. 创建一个队列 ； 只要队列不为空就循环，循环体内，弹出当前节点（要对其增加左右儿子），
       *             按照（左右）顺序，数组中有数据，新建一个节点入队列
       */
        public Node<T> createTreeByLayerSequen(T[] datas ){
            if (datas.length == 0)
                return null;
            Queue<Node<T>> q  = new LinkedList<>();
            Node<T> root = new Node<>(null,null,datas[0]);
            q.offer(root);
            int count = 1;
            // 如果数据没了，队列中还有节点，无所谓，因为初始化时，已经指定了左右节点默认为空，无需显示处理一下
            while (!q.isEmpty() && count < datas.length){
               Node<T> tempRoot = q.poll();
                //还有数据
                 if (count < datas.length){
                    T val = datas[count];
                    tempRoot.left  = new Node<>(null,null,val);
                    count++;
                    q.offer(tempRoot.left );
                }else {
                     tempRoot.left = null;
                 }
                 //还有数据
                 if (count < datas.length){
                    T val = datas[count];
                    tempRoot.right  = new Node<>(null,null,val);
                    count++;
                    q.offer(tempRoot.right );
                }else{
                     tempRoot.right = null;
                 }
            }
            return root;
        }

        /**
         *先序生成二叉树
         * @createTime 2019/12/20 20:20
         * @param
         * @desc 数据是输入的, 判断输入数据
         */
        public   Node<Integer> create(Node<Integer> node) {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入节点的值：");
            int value = in.nextInt();

            if (value != 0) {
                node = new Node();
                node.value = value;
                node.left = create(node.left);
                node.right = create(node.right);
            } else {
                //下面的步骤至关重要！！！
                node = null;
            }
            return node;
        }
        /**
         * 求二叉树的高度: 递归求
         * @param [node]
         * @return int
         */
        public int height(Node<T> node){
            if (node == null){
                return 0;
            }
            int leftH = height(node.left);
            int rightH = height(node.right);
            return Math.max(leftH,rightH) + 1;
        }
        /**
         *打印叶子节点
         * @param [node]
         * @desc  采用先序遍历方式，不同的是，加上了条件
         */
        public void printleafNode(Node<T> node){
            if (node == null)
                return;
             if (node.left == null && node.right ==null)
                 System.out.printf("--"+node.value);
             printleafNode(node.left);
             printleafNode(node.right);
         }
         /**
          * 层序遍历
          * @param [root]
          * @desc
          */
         public void layerTraversal(Node<T> root){
             if (root == null)
                 return;
             Queue<Node<T>> myq = new LinkedList<>();
             myq.offer(root);
             while (!myq.isEmpty()){
                 Node<T> temp = myq.poll();
                 System.out.printf(""+temp.value);
                 if (temp.left!= null)
                     myq.offer(temp.left);
                 if (temp.right!= null)
                     myq.offer(temp.right);
             }
         }
         // 三种递归遍历
        /**
         * 先序编列
         * @author leaderHoo
         * @createTime 2019/12/20 21:02
         */
         public void preOrderTraversal(Node<T> bt){
             if (bt != null){
                 System.out.printf("-"+bt.value);
                 preOrderTraversal(bt.left);
                 preOrderTraversal(bt.right);
             }
         }
        /**
         * 中序编列
         * @author leaderHoo
         * @createTime 2019/12/20 21:02
         */
         public void midOrderTraversal(Node<T> bt){
             if (bt != null){
                 midOrderTraversal(bt.left);
                 System.out.printf("-"+bt.value);
                 midOrderTraversal(bt.right);
             }
         }
        /**
         * 后序编列
         * @author leaderHoo
         * @createTime 2019/12/20 21:02
         */
         public void backOrderTraversal(Node<T> bt){
             if (bt != null){
                 backOrderTraversal(bt.left);
                 System.out.printf("-"+bt.value);
                 backOrderTraversal(bt.right);
             }
         }
         //三种非递归遍历
        /**
         * 非递归先序遍历
         * @author leaderHoo
         * @createTime 2019/12/20 21:06
         */
        public void preOrderTraversalNoResc(Node<T> bt){
            if (bt ==null)
                return;
            Stack<Node<T>> s = new Stack<>();
            while (!s.empty() && bt != null){
                //先序 ： 根左右 ， 思路 ：打印（就是处理根节点），入栈，指向左儿子
                while (bt != null){
                    System.out.printf("-"+bt.value); //先序遍历，入栈之前先访问
                    s.push(bt);
                    bt = bt.left;
                }
                Node<T> temp = s.pop();
                bt = temp.right;
            }

        }
        /**
         * 中序遍历 左根右
         * @author leaderHoo
         * @desc 思路 只要左儿子不空，全入栈 ；
         *         一直到左儿子空了，弹出（此节点无左儿子，可能有右儿子），打印此节点根， 指向右儿子，处理；
         *
         *
         *    先序和中序类似 ： 不同之处，先序是入栈的时候，就要访问节点（从根节点看顺序，根左右）
         *     中序是 到最左边的节点（该节点左儿子为空），再访问这个节点、右儿子
         */
        public void midOrderTraversalNoResc(Node<T> bt){
            Stack<Node<T>> s = new Stack<>();
            while (bt != null && !s.isEmpty()){
                while (bt != null){
                    s.push(bt);
                    bt = bt.left;
                }
                Node<T> temp = s.pop();
                System.out.printf("--"+temp.value); // 中序遍历： 弹出之后，再访问
                bt = temp.right;
            }

        }


    public void postTraByStack() {
        System.out.println("后序非递归遍历，借助栈");
        //新建栈，先进后出,将根结点入栈,双端队列
        Deque<Node> stack = new LinkedList<>();
        //新建一个list，记录结点的状态是否已经被访问过
        ArrayList<Node> list = new ArrayList<>();
//		stack.push(root);
        Node proot;
        Node node = root;
        int flag;
        //首先检查完树的左子树，再右子树，最后将根节点输出
        while (node != null || stack.size() > 0) {
            //将最左子树添加完毕
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //和中序遍历相似，为先输出左结点，但是做结点输出完毕之后，不能直接将根结点弹出，而是必须先将右结点弹出，
            //最后再将根结点弹出来，就会牵扯到一个根结点的访问状态的问题，是否已经被遍历过了
            //利用一个list集合记录已将被遍历过的根结点，防止产生死循环
            if (stack.size() > 0) {
                Node peek = stack.peek();
                if (peek.right != null) {
                    boolean con = list.contains(peek);
                    if (con == true) {
                        Node pop = stack.pop();
                        System.out.print(pop.value + "  ");
                    } else {
                        list.add(peek);
                        node = peek.right;
                    }
                } else {
                    Node pop = stack.pop();
                    System.out.print(pop.value + "  ");
                }
            }
        }
    }

}


