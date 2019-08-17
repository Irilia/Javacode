package com.irilia.client.dao;

import com.irilia.client.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();
    //测试注册
    @Test
    public void userReg() {
        User user = new User();
        user.setUserName("test2");
        user.setPassword("123");
        user.setBrief("啾啾啾");
        boolean b = accountDao.userReg(user);
        Assert.assertTrue(b);
    }

    //测试登录
    @Test
    public void userLogin() {
        User user = accountDao.userLogin("test","123");
        Assert.assertNotNull(user);
    }
}