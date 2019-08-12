package com.irilia;

import com.irilia.util.CommUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class JDBCTest {
    //静态属性只加载一次
    private static String url;
    private static String userName;
    private static String password;

    //静态代码块：信息加载一次，并且提前加载
    static {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = CommUtils.loadProperties("db.properties");
        url = properties.getProperty("url");
        userName = properties.getProperty("username");
        password = properties.getProperty("password");
    }
    @Test
    //测试JDBC的查询操作
    public void queryTest() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id为"+id+",用户名为："+userName+"，密码为："+password);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            connection.close();
            statement.close();
            resultSet.close();
        }
    }
    @Test
    //测试JDBC的插入操作
    public void insertTest(){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(url,userName,password);
            String sql = "INSERT INTO user(username, password) VALUES ('test3','456')";
            statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            Assert.assertEquals(1,row);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    @Test
    //删除操作
    public void deleteTest(){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(url,userName,password);
            String sql = "DELETE FROM user WHERE id = '2'";
            statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            Assert.assertEquals(1,row);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    @Test
    public void updateTest(){
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(url,userName,password);
            String sql = "UPDATE user SET password='123' WHERE id='4'";
            statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            Assert.assertEquals(1,row);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}
