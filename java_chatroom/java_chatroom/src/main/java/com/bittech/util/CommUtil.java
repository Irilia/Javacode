package com.bittech.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: yuisama
 * @Date: 2019-08-16 10:20
 * @Description:封装所有公共操作，包括加载配置文件、json操作等
 */
public class CommUtil {
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        InputStream in = CommUtil.class.getClassLoader()
                .getResourceAsStream(fileName);
        try {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("资源文件加载失败");
            e.printStackTrace();
            return null;
        }
        return properties;
    }

}
