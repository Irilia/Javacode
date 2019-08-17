package com.irilia.client.entity;

import lombok.Data;

//数据库的实体类，用来描述数据库的表中的属性，
//类型必须要用包装类，因为如果用来基本类型，默认值是0，而0不是null，
//如果刚好这个表中有另一个设置为0的就会将这个值为0的用户的数据修改。
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String brief;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
