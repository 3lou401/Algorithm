package com.algorithm;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/17 21:10
 * @Desc: 符号配对 ： /* (与)、[与]、{与}
 * */
 class StringStack {

    private int maxSize;
    private String[] stackArray;
    private int top;

    public StringStack(int maxSize){
        this.maxSize = maxSize;
        stackArray = new String[maxSize];	//初始化数组
        top = -1;	//初始化栈顶指针为-1
    }

    public void push(String i) throws Exception{
        if(isFull()){
            throw new Exception("栈已经满了");
        }
        top = top+1;
        stackArray[top] = i;
    }

    public String peek(){
        return stackArray[top];
    }

    public String pop() throws Exception{
        if(isEmpty()){
            throw new Exception("栈为空");
        }
        String pelement = stackArray[top];		//待出栈的元素
        top = top - 1;
        return pelement;
    }

    public int getStackSize(){
        return top + 1;
    }
    public boolean isFull(){
        if(top == maxSize -1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

}
public class MatchBracket {

    public static String[] leftBracket = {"(","[","{"};
    public static String[] rightBracket = {")","]","}"};


    public int pushLeft(StringStack stringStack, String bracket) throws Exception{
        for(int i=0; i < leftBracket.length; i++){
            if(leftBracket[i].equals(bracket)){
                stringStack.push(bracket);
                return i;
            }
        }
        return -1;
    }

    public boolean matchLeft(StringStack stringStack, String bracket) throws Exception{
        for(int i = 0; i < rightBracket.length; i++){
            if(rightBracket[i].equals(bracket)){
                //右边符号数目大于左边符号
                if(stringStack.isEmpty()){
                    return false;
                }
                //查看栈顶符号是否匹配左边符号
                if(stringStack.peek().equals(leftBracket[i])){
                    stringStack.pop();
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMatch(String inputStr, StringStack stack) throws Exception{
        char[] charArray = inputStr.toCharArray();
        for(char c : charArray){
            String bracket = String.valueOf(c);
            pushLeft(stack, bracket);
            boolean res = matchLeft(stack, bracket);
            if(!res){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        String machStr = "{Anti_Polish{b(c)}d}e";
        char[] charArray = machStr.toCharArray();
        StringStack stringStack = new StringStack(20);
        MatchBracket matchBracket = new MatchBracket();
        System.out.println(matchBracket.isMatch(machStr, stringStack));

    }

}