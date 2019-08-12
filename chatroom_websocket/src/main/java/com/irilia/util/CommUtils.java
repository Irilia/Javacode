package com.irilia.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//封装公共的工具方法
public class CommUtils {
    //方法：加载配置文件信息
    //fileName：要加载的配置文件名称
    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        //将配置文件转为输入流
        InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(fileName);
        //加载配置信息
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
