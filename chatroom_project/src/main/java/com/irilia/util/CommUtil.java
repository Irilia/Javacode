package com.irilia.util;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//封装所有的共有方法：加载资源文件，json操作
public class CommUtil {
    //创建一个gson对象
    private static final Gson GSON = new GsonBuilder().create();
    //加载资源文件：url，jdbc驱动
    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        //加载配置文件要获取该文件的输入流，先获取类加载器，再读取同目录下的资源文件夹Resource
        InputStream in = CommUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            //加载输入流
            properties.load(in);
        } catch (IOException e) {
            //报错信息
            System.out.println("资源文件加载失败");
            e.printStackTrace();
            return null;
        }
        //如果加载成功，就返回加载的流
        return properties;
    }

    //将任意对象系列化为json字符串
    public static String objectToJson(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    //将json字符串反序列化为对象:得知道要反序列化的对象，和要反序列化为什么类型的对象，所以要得到这个类的反射对象
    public static Object jsonToObject(String Jsonstr,Class objClz){
        Gson gson = new Gson();
        return gson.fromJson(Jsonstr,objClz);
    }
}
