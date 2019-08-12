package com.irilia.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilsTest {

    @Test
    public void loadProperties() {
        Properties properties = CommUtils.loadProperties("db.properties");
        String url = properties.getProperty("url");
        Assert.assertNull(url);
        Assert.assertNotNull(url);
    }
}