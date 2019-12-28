package com.dataStructure;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.security.Permission;

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
// 将关键字作为参数，通过函数（哈希函数），计算出一个值作为实际存储的内存地址 ，又称作“关键字-地址转换法”

// 例子一 ： 整数集合 18 23 27 21 15 ... (11个整数) ，如果符号表大小TableSize选择17， 哈希函数选择
// hash(k) = k mod TableSize ;  可以直接将11个整数保存到哈希表中
//插入 ： 计算出地址，保存，O(1)  查找 ：计算出地址，查看是否存在，O(1)

// 一般情况下 ， 设散列表大小m, 保存的关键字个数是n , 则称 α = n/m 为  “装填因子”（Loading Factor）
// 后边的几种散列方法，会分析装填因子，一般装填因子在0.5-0.8合适

// 冲突：
// 经过散列函数变换后，两个不同的key,被散列到同一个存储空间，即 key1 !=key2 && hash(key1) == hash(key2) 就是冲突
// 映射到同一地址的关键字，称为“同义词”

// 例子二 ： 10个英文词，散列到一个表中， acos、define、float、exp、char、atan、ceil、floor、clock、ctime
// 根据关键字均为小写字母 ，可用二维数组 Table[26][2]保存，散列函数设计为 h(key) = key[0] - 'a'
// 如果第一次发生冲突，保存到 table[h(key)][1]，如果再有，那就无法保存这个关键字

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
    // 发生第i次冲突之后， h(key) =( h(key) + di) mod TableSize ， 必须对TableSize取余
    // 开放定址法 ： 要求，删除做到假删除
    private class  OpenAddressing{
        int TableSize;
        // 1. 线性探测法 : di 选择i ， 即增量序列是1,2,3,4,5...(TableSize - 1)来试探下一个存储地址
        // 插入时，要找到一个空位置或者直到散列表已满 。 查找时，通过散列函数计算出位置，比较关键字，不是就按照步长往下找，直到找到或者为空。
        //为了保证查找正确，删除需要假删除
        // 如下伪码 ： key是关键字， result是关键字散列之后保存的数组
         public void solveInsert1(String[] key, String[] result){
             int count = 1;
             for(int i= 0; i < key.length;i++){
                 int hashVal = h1(key[i]);
                 //TODO 初步思想
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
        // 线性探测法使得i位置的元素被散列到i+1位置，导致很多元素在相邻位置堆积起来，形成一次聚集，大大降低查找效率
        // “一次聚集”，就是Hash(key) 不是这个位置的元素，占了这个位置，导致元素聚集


        // 2 . 平方探测法 : di选择 正负i^2， 即增量序列以 1^2， -1^2， 2^2 ，-2^2 ...q^2 (q <= tableSize/2)
        //相比于线性探测，步长变为以前的平方
        //类似 线性探测法，插入的时候，也是找一个空位置或者直到散列表已满 ； 查找的时候，也是比较关键字，不是就依据步长往下； 删除也是假删除
        // 解决了“一次聚集”，但是hash(key)相同的元素，还是会聚集到一起，叫做“二次聚集”
        //算是 常用的方法

        // 3. 双散列探测法
        // di选择另一个探测函数 h2(key)
        // h(key) = (h(key) + i * h2(key)) % TableSize;
        //递增序列就是 1*h2(key),2*h2(key),3*h2(key),4*h2(key) ，要求第二个递增函数要选择好，如果都是0那就凉凉了
        //理论上很有吸引力，不过平方探测法不需要第二个探测函数，因为会更常用
        public void solveInsert3(String[] key, String [] result){

        }
        // 4. 再散列法
        // 在一定时间下，表长是固定的，装填因子太大，填入的元素越多，冲突的可能性就越大
        //当装填因子过大时，可以采取，加倍扩大散列表，将原有的元素散列到新的表中，从而降低装填因子，这个过程叫做“ReHashing”,再散列
        //这个过程，耗时长，在交互系统中，会有明显停顿，实时系统慎用
    }

    //方法二 ：链地址法(Linear Probing)
    //分离链接法（链接法） Sperator Chaining
    //核心思想是，将散列到同一个地址的关键字，通过链表连接起来，存储在同一个单链表中
    // 优势是 删除关键词的操作可以直接实现，分离链表法比开放定址法要更好
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

    SysTable sysTable;

    // 返回大于N且小于MaxTableSize最小素数
    public int nextPrime(int N){
        int i, p = (N % 2 == 0)? N +1 : N + 2;
        while (p < MaxTableSize){
            for (i = (int)Math.sqrt(p);i > 2; i--){
                if (p % i == 0)
                    break; //可以整除说明不是素数
            }
            if (i == 2) {
                //说明是正常跳出循环，没有找到整除的
                break;
            }else {
                p +=2;
            }
        }
        return p;
    }

    public OpenAddrUseCase() {
    }

    public  OpenAddrUseCase(int tableSize){
        int primeTableSize = nextPrime(tableSize);
        sysTable.TableSize = primeTableSize;
        sysTable.sysTables = new Element[primeTableSize];
        for (int i = 0; i < primeTableSize;i++){
            sysTable.sysTables[i].type = IndexType.Empty;
        }
    }

    // 平方探测法，查找方法, key暂时还用int类型其他的类型相似
    int findKey(int key) {
        int CurrentPos, NewPos;
        int Cnum = 0;
        NewPos = CurrentPos = Hash(key);
        int tableSize = sysTable.TableSize;
        //元素不是空的，也不是要查找的，就按照步长往下找，步长是±i^2
        while (sysTable.sysTables[NewPos].type != IndexType.Empty
                && sysTable.sysTables[NewPos].element != key) {
            Cnum++;
            if (Cnum % 2 != 0) {
                //奇数次，为正, 因为是正负平方，所以增量是 Cnum+1/2
                // 2/2 ，4/2,6/2  对应 1,2,3..)
                NewPos = CurrentPos + (int) Math.pow((int) ((Cnum + 1) / 2), 2);
                NewPos = NewPos % tableSize;
            } else {
                //偶数次，为负数 1/2,3/2
                NewPos = CurrentPos - (int) Math.pow((int) Cnum / 2, 2);
                if (NewPos < tableSize)
                    NewPos += tableSize;
                NewPos %= tableSize;
            }
        }
        // 可以通过这个位置的元素的类型判断
        return NewPos; // 这是元素的位置，或者是一个空单元的位置，
    }
    private int Hash(int key){
        throw  new NotImplementedException();
    }
    // 平方探测法的插入函数
    public boolean insert(int key){
        int pos = findKey(key);
        if (sysTable.sysTables[pos].type != IndexType.Legitimate ){
            //说明这个元素是没有被占用的，可以进行插入
            sysTable.sysTables[pos].type = IndexType.Legitimate;
            sysTable.sysTables[pos].element = key;
            return true;
        }else{
            System.out.printf("该关键字已经存在了");
            return false;
        }
    }


}

//2 . 分离链接法的代码
class SperatorChaining{
    private class Node{
        int value;
        Node next;
    }

    //散列表
    private class SysTable2{
        Node[] tables;
        int tableSize;
    }
    SysTable2 sysTable2;

    public SperatorChaining(int TableSize) {
        sysTable2.tableSize = TableSize;
        sysTable2.tables = new Node[TableSize];
    }

   public  Node find(int key){
        Node p;
        int pos;
        pos = Hash(key);
        p = sysTable2.tables[pos];
        while (p != null  && p.value!= key){
            p = p.next;
        }
        return p; //可能是返回的值，也可能是空
    }

    public boolean insert(int key){
        Node p,newCell;
        p = find(key);
        if (p!= null){
            System.out.printf("关键字已经存在");
            return false;
        }else {
            //头插法，找到散列的存储位置
            Node head =sysTable2.tables[ Hash(key)]; //head作为一个空的头指针
            newCell = new Node();
            newCell.value = key;
            newCell.next = head.next;
            head.next = newCell;
            return true;
        }
    }

    public boolean delete(int key){
        Node p = find(key);
        if (p == null)
            return false;
        int pos = Hash(key);
        Node prev,temp;
        prev = sysTable2.tables[pos];
        temp = prev.next;

        while (temp!= null && temp.value != key){
            prev = temp;
            temp = temp.next;
        }
        if (temp!=null){
            //找到元素了，删除
            prev.next =temp.next;
            //GC
            temp.value=0;
            temp.next = null;
            return true;
        }
        return false;
    }

    private  int Hash(int key){
        throw  new NotImplementedException();
    }
}
