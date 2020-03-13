package com.designModel.active.state;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/2 13:28
 * @Desc:
 */
public class TcpExam {
    public static void main(String[] args) {
        TcpConection tcpConection = new TcpConection();
        tcpConection.setTcpState(new TcpEstablished());
        tcpConection.open();
    }
}
//环境类
class TcpConection{
    private TcpState tcpState;
    public TcpState getTcpState() {   return tcpState;    }
    public void setTcpState(TcpState tcpState) {        this.tcpState = tcpState;    }
    public void open(){        tcpState.open();    }
    public void close(){        tcpState.close();    }
    public void acknowledge(){        tcpState.acknowledge();    }
}
// 抽象状态
abstract class TcpState{
    abstract void open();
    abstract void close();
    abstract void acknowledge();
}
//具体环境类
class TcpEstablished extends TcpState{
    @Override
    void open() {
        System.out.println("刚建立连接，opening");
    }
    @Override
    void close() {
        System.out.println("可以关闭");
    }
    @Override
    void acknowledge() {
        System.out.println("这是建立连接");
    }
}


