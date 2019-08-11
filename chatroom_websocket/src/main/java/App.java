import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // 1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 2.获取连接
        String url = "jdbc:mysql://localhost:3306/jdbc_test";
        String username = "root";
        String password = "998720";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(
                    url,username,password
            );
            // 3.执行SQL
            statement = connection.createStatement();
            String sqlStr = "SELECT * FROM user";
            rs = statement.executeQuery(sqlStr);
            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("username");
                String ps = rs.getString("password");
                System.out.println("id为"+id+",用户名为:"+
                        userName+",密码为:"+ps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 4.关闭资源
            try {
                connection.close();
                statement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        // 将配置文件转为输入流
        InputStream in = CommUtils.class.getClassLoader()
                .getResourceAsStream(fileName);
        // 加载配置信息
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
