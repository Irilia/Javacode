package com.irilia.client.dao;

import com.irilia.client.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

//具体的业务层，用户的dao，继承BasedDao，就有了数据源，也有了获取资源关闭资源的能力
//只需要写账户的增删改查
public class AccountDao extends BasedDao {
    //新增用户，成功返回true，失败返回false
    //注册用户，需要修改数据库，所以需要一个数据库的实体类：User
    //insert:需要Connection，preparedStatement
    public boolean userReg(User user){
        //获取资源
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取的资源是从父类哪里继承来的
            connection = getConnection();
            //要执行的SQL语句，用占位符来赋值，需要从外部传入
            String sql = "INSERT INTO user(username, password, brief)"+"VALUES(?,?,?)";
            //预编译SQL,获取自动增加的id号
            //执行这个SQL语句，受影响的行数是几
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //插入，第一个，值从表的实体类中获得
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,DigestUtils.md5Hex(user.getPassword()));
            preparedStatement.setString(3,user.getBrief());
            //方法executeUpdate 用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
            //插入成功返回1，失败返回0
            int rows = preparedStatement.executeUpdate();
            if(rows == 1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("用户注册失败");
            e.printStackTrace();
        }finally {
            //关闭资源
            closeResources(connection,preparedStatement);
        }
        return false;
    }

    //登录操作
    //查询操作，返回属性值
    public User userLogin(String userName,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM user WHERE username = ? AND password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,DigestUtils.md5Hex(password));
            //jdbc连接数据库的第四步，查询
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setBrief(resultSet.getString("brief"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println("用户登录失败");
            e.printStackTrace();
        }finally {
            closeResources(connection,preparedStatement,resultSet);
        }
        return null;

    }
}
