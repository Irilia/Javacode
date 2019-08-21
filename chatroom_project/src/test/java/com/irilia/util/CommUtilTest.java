package com.irilia.util;

import com.irilia.client.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilTest {

    @Test
    public void loadProperties() {
        //传入资源文件测试
        Properties pros = CommUtil.loadProperties("db.properties");
        Assert.assertNotNull(pros);
    }
    @Test
    public void obj2Json(){
        User user = new User();
        user.setUserName("test");
        user.setPassword("123");
        user.setBrief("啾啾啾");
        String str = CommUtil.objectToJson(user);
        System.out.println(str);
    }
    @Test
    public void json2Obj(){
        String str = "{\"userName\":\"test\",\"password\":\"123\",\"brief\":\"啾啾啾\"}";
        User user = (User) CommUtil.jsonToObject(str,User.class);
        System.out.println(user);
    }
}