package com.utils.db.mysql;

import lombok.NonNull;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 16:55
 * Description: No Description
 */
public class MysqlConnector {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = " jdbc:mysql://127.0.0.1:3306/test";
    static String user = "root";
    static String password = "root";

    public static Connection getConnection(){

        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public  static  void close(Connection con, Statement st, ResultSet rs){
        try {
            if(con != null){
                con.close();
            }
            if(st != null){
                st.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ResultSet execQuery(@NonNull  String sql,Object[] params){
        ResultSet resultSet = null;
        //使用 try-with-resources
        try(Connection con = getConnection();) {
           PreparedStatement ps =  con.prepareStatement(sql);
            if (params != null && params.length > 0){
                for (int i=0; i< params.length;i++){
                    ps.setObject(i,params[i]);
                }
            }
             resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static int  execQueryUpdate(@NonNull  String sql,Object[] params){
        //使用 try-with-resources
        int col = 0;
        try(Connection con = getConnection();) {
           PreparedStatement ps =  con.prepareStatement(sql);
            if (params != null && params.length > 0){
                for (int i=0; i< params.length;i++){
                    ps.setObject(i,params[i]);
                }
            }
             col = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return col;
    }

    //TODO 驱动包不对
    public static void main(String[] args) {
        String sql = " SELECT KeyVal from keytable" ;
        ResultSet set = execQuery(sql,null);
        System.out.println();
    }
}
