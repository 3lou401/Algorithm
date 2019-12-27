package com.dataStructure;

import sun.awt.Symbol;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/26 16:27
 */
public class Hash {
}

//1. 顺序查找：O(N), 二分查找 ： O(logN)
// 二分查找 要求数据有序，并且不会经常变动（静态查找）
//N很大时，并且经常插入删除时，二叉搜索树查找O(h) h是二叉搜索树高度，最好O(logN)、最坏O(N)

//2. 其他适应性广，而且速度快的查询方法 ？
//情景1 ：在十几亿QQ号中，查找一个QQ号，
//分析：如果用二分查找 十几亿QQ号，可能需要1G的存储，目前可以满足，但是频繁插入无法满足

//情景2 ： 查字典，比如查询zoo, 我们可以大约直接翻到，
//我们就是先估算 关键字的大体位置


//3. 举例， 百度或者谷歌搜索的时候，使用倒排索引，关键字对应文档，（正常的索引是  文档对应关键字）
//如果 关键字M ： 3:1,2,3 说明关键字m在这个文档中出现3次，分别是第一行，第二行，第3行


//符号表
//上边保存“关键字-文档”的集合，实际上就是符号表 ，它的定义是 ：
// 名字-属性 对应的集合
abstract  class SymbolTable<K,V>{
    abstract  SymbolTable<K,V> create(int MaxSize);
    abstract boolean modify(K key,V val);
    //符号表，最核心的操作是查找插入删除
    abstract V find(K key);
    abstract boolean containKey(K key);
    abstract boolean insert(K key,V val);
    abstract boolean delete(K key);
}

// 使用哈希技术创建的 “符号表” 就是 “哈希表”
// 散列（Hashing）技术
// 将关键字，通过函数（哈希函数），计算出一个值作为实际存储的内存地址 ，又称作“关键字-地址转换法”

// 例子一 ： 整数集合 18 23 27 21 15 ... (11个整数) ，如果符号表大小TableSize选择17， 哈希函数选择
// hash(k) = k mod TableSize ;  可以直接将11个整数保存到哈希表中
//插入 ： 计算出地址，保存，O(1)  查找 ：计算出地址，查看是否存在，O(1)

// 一般情况下 ， 设散列表大小m, 保存的关键字个数是n , 则称 α = n/m 为  “装填因子”（Loading Factor）
// 后边的几种散列方法，会分析装填因子，一般装填因子在0.5-0.8合适

// 冲突：
// 经过散列函数变换后，两个不同的key,被散列到同一个存储空间， 就是冲突
// 映射到同一地址的，称为“同义词”

// 例子二 ： 10个英文词，散列到一个表中， acos、define、float、exp、char、atan、
// ceil、floor、clock、ctime
// 根据关键字均为小写字母 ，可用二维数组 Table[26][2]保存，散列函数设计为 h(key) = key[0] - 'a'
// 如果发生冲突，保存到 table[h(key)][1]，如果再有，那就无法保存这个关键字
//这种，在同一个散列地址，定义多个槽（slot）的方式的确可以解决部分冲突。
//但在本例中，实际上clock、ctime无法保存了，实际上的 “装填因子”只有  8/(26*2) ,很低
// 这种方式很差

//散列方法需要解决问题
//1.构造好的“散列函数”
//2.指定“解决冲突方法”

//好的散列函数
//1.计算简单
//2. 关键字对应散列空间均匀，减少冲突

//关键字为数字的散列函数选择：
class NumberHash{
    int a,b;
    //1.直接定值法 ：如下，a,b都是常数，
    // 比如，统计个年龄人数，年龄1的直接在地址1,2在2,3在3 ，此时 h(key)=key
    // 再比如， 统计1990之后各个年份出生的， 1990出生的在0 ，91出生在1，此时h(key)= key - 1990
    // 这种方式，计算简单，分布均匀，但是需要的散列空间与关键字大小相当，
    // 不常用，比如关键字有个6000的，其他都是100以内，也得需要6000个空间
    public int fun1(int key){
        return a * key + b;
    }


    //方法二 ： 除留余数法（取余，mod运算）
    // 设散列表长度为TableSize(TableSize选取与集合关键字大小、装填因子有关)
    // 一般 p <= TableSize && p ∈ 素数 ，会好一点
    //比较常用  h(key) = key mod p;
    public int fun2(int p,int key){
        return key % p ;
    }

    //方法三 : 数字分析法
    // 关键字，位数比较大，有些位数容易相同，比如手机号，
    // 一般手机号，前三位容易相同，中间四位属于归属地，也容易相同，只有后四位是用户随机的
    // 容易相同的位数，如果使用随机函数，会很容易聚集，因此可以选择，随机的位数进行计算，
    // 比如可以选择 h(key) = substr(key,4) 只取最后四位，如果还大，可以再结合取余方式
    //同样的例子，比如身份证号
    public int fun3(int key){
        //将key转为字符串，只取部分位数
        String keyS = String.valueOf(key);
        return analyze(keyS);
    }
    private int analyze(String keys){
        throw new NotImplementedException();
    }
}

//关键字为字符串的散列函数选择
class StringHash{
    // 方法一 ;ASIC码加和法 h(key) = sum(c1,c2,c3...) % TableSize c1,c2,c3是字符串中的每一个字符
    // 函数很简单，但均匀性很差， 比如 eat ate tea  , 或者 a3,b2,c1 都会散列到同一个地址
    // 不常用
    public int func1(String key,int TableSize){
        int sum = 0;
        for (int i= 0; i < key.length();i++){
            sum += (int) key.charAt(i);
        }
        return sum % TableSize;
    }
    // 方法二 ：前三个字符移位法
    // 上边方法一并没有区分字符出现位置，分布不均匀
    // 哈希函数 h(key) = (key[0] * 27^0 + key[1] * 27^1 + key[2] * 27^2) % TableSize
    //选择 27是因为 26个字母 加上一个空格符，
     // 缺点 ： 实际上英文字母不是随机的，前三位大概也就是3000种，比如 String Strong ,而一共有26^3种，
    // 空间浪费很大，装填因子小， 不常用
     public int func2(String key,int TableSize){
        return ( key.charAt(0) * 1 + key.charAt(1) * 27 +key.charAt(2) * 27 * 27) %TableSize;
     }

     // 方法三 ： 所有字符移位法 ，这是好的散列方式
    // 选择32 ，不是27，因为32便于计算可以直接通过左移五位实现 ： i << 5 = i * 2^5 = 32 * i
    // 选择每个字符都去乘32
    // h(key) = sum(key[i] * 32^i ）% TableSize
    //快速计算：
     //h(“abcde”)=‘a’*324+’b’*323+’c’*322+’d’*32+’e’
     //实际计算过程如下：
     //h = a
     //h = a * 32 + b
     //h = (a * 32 +b) * 32 + c
     //h = ((a * 32 + b) * 32 + c) * 32 + d
     //h = (((a * 32 + b) * 32 + c) * 32 + d) * 32 + e
     //h = h%TableSize
     //这里a * 32 == a<<5，左移5位相当于乘以32
    public int func3(String key,int TableSize){
        int sum = 0;
        for (int i = 0; i < key.length();i++){
            sum = sum << 5 + key.charAt(i);
        }
        return sum % TableSize;
    }

    public static void main(String[] args) {
        System.out.printf("--"+(1<<5));
    }

}


//处理冲突的方式 : 代码都是伪码的形式
class SolveConflict{
    //方法一 ：开放定址法 （Open Addressing）
    //思想是 ：一旦冲突了，就去寻找下一个空的散列地址
    //h(key) =( h(key) + di) mod TableSize;
    // 根据di取值不同，又可以分为
    private class  OpenAddressing{
        int TableSize;
        // 1. 线性探测法 : di 选择i
        // 当我们往散列表中插入数据时，如果某个数据经过散列函数之后，存储的位置已经被占用了，
        // 我们就从当前位置开始，依次往后查找（到底后从头开始），看是否有空闲位置，直到找到为止
        // 如下伪码 ： key是关键字， result是关键字散列之后保存的数组
         public void solveInsert1(String[] key, String[] result){
             int count = 1;
             for(int i= 0; i < key.length;i++){
                 int hashVal = h1(key[i]);
                 while (result[hashVal] != null){
                     hashVal = (h1(key[i])+ count) % TableSize;
                     count++;
                 }
                 if (result[hashVal] == null){
                     count = 0;
                     result[hashVal] = key[i];
                 }
             }
         }
         private int h1(String k){
             throw  new NotImplementedException();
         }
         //查找的时候，通过散列函数计算出位置，看一下是否相等，不等，需要顺序往下找，一直到空闲位置，没找到就是没有
         // 为了保证查找到时候，空闲的位置，不是插入，后来又删除的，这里删除可以用假删除，标记
        // 这种方式缺点很明显，本来散列到i位置的元素，可能因为其位置被占了，只能往后散列，增加查找的复杂度，
        // 这种情况叫“一次聚集”，就是Hash(key) 不是这个位置的元素，占了这个位置，导致元素聚集

        // 2 . 平方探测法 : di选择 正负i^2， 即增量序列以 1^2， -1^2， 2^2 ，-2^2 ...
        //相比于线性探测，步长变为以前的平方
        public void solveInsert2(String[] key, String [] result){
            int count = 1;
            int flag = 1; //判断递增因子是正负的
            for(int i= 0; i < key.length;i++){
                int hashVal = h1(key[i]);
                while (result[hashVal] != null){
                    int value = (int) (flag *Math.pow(count,2));
                    flag = - flag;
                    count++;
                    hashVal = (h1(key[i])+ value) % TableSize;
                }
                if (result[hashVal] == null){
                    count = 0;
                    result[hashVal] = key[i];
                }
            }
        }
        //同样的方式，查找的时候，通过散列计算出来位置，元素不是要查找的，
        // 就需要按照增量序列计算地址，去判断， 一直到找到未插入元素节点
        // 删除的时候，假删除
        // 解决了“一次聚集”，但是hash(key)相同的元素，还是会聚集到一起，叫做“二次聚集”
        //算是 常用的方法

        // 3. 双散列探测法
        public void solveInsert3(String[] key, String [] result){

        }
        // 4. 再散列法
    }

    //方法二 ：链地址法(Linear Probing)
    private class  LinearProbing{

    }
}


//1. 开放定址法的代码 ,
class OpenAddrUseCase{
    //数据结构
    public static final  int MaxTableSize = 10000;

    //元素类型
    private  enum IndexType{
        Legitimate, Empty, Deleted
    }

    private class Element{
        IndexType type;
        int  element; //保存的元素，目前先是Int类型
    }
    private class SysTable{
        Element[] sysTables; //散列表类型
        int TableSize;// 散列表大小
    }
}
