package com.irilia.util;

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
}