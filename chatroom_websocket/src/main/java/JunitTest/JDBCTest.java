package JunitTest;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    @Test
    //测试JDBC的插入操作
    public void inserTest(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection();
            String sql = "INSERT INTO user(username,password) VALUES ('test3,123')";
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            Assert.assertEquals(1,rows);
        } catch (SQLException e) {
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
