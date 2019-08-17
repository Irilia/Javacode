package com.bittech.client.entity;

import lombok.Data;

/**
 * @Author: yuisama
 * @Date: 2019-08-16 10:34
 * @Description:user表的实体类
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String brief;
}
