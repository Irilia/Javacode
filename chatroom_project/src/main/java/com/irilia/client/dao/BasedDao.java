package com.irilia.client.dao;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.irilia.util.CommUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//dao层的顶层父类，分装数据源，获取连接，关闭资源等共有操作
//加载数据源，获取连接，关闭资源的操作都是在数据库中完成的，不是所有的动作都需要，所以利用继承的特性来使需要这些操作的类获得这些操作。
public class BasedDao {
    private static DruidDataSource DATASOURCE;
    //1.加载数据源，利用静态代码块保证类一被new就会加载数据源。
    static {
        Properties pros = CommUtil.loadProperties("db.properties");
        try {
            //加载数据源需要加载资源文件
            DATASOURCE = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            System.err.println("数据源加载失败");
            e.printStackTrace();
        }
    }

    //2.获取连接,所有子类都要能获取。
    protected Connection getConnection(){
        try{
            //设置连接可以重复利用getPooledConnection
            return (Connection) DATASOURCE.getPooledConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //4.关闭资源
    protected void closeResources(Connection connection, Statement statement){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //重载
    protected void closeResources(Connection connection, Statement statement, ResultSet resultSet){
        //复用上面的方法
        closeResources(connection,statement);
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
