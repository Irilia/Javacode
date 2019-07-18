package com.irilia.xml.read;

import java.io.Serializable;

/*
web模型模式：
    1.jsp+bean (维护不方便，开发成本高)
    2.jsp+servelet+bean:  mvc设计模型
                                   分层：
                                        web层
                                            servlet：后台获取前台传递的参数
                                                调用service
                                            在web里重定向，请求转发（跳转页面）
                                        service层
                                            具体业务层
                                            调用dao层
                                        dao层（Data Access Object：数据访问对象）
                                            curd
JavaBean
    满足的条件：1.当前类必须是一个具体类 public class
                    2.提供私有字段（属性）：private String id；（id私有字段）
                    3.提供对应的setXX()/getXX()/itXX()
                            例如：public void getId()/public String setId()
                            将Id-->首字母小写（id）--->称为当前bean属性
                    4.在网络上的话当前类必须要实现序列化接口：serializable
                        例如：缓存技术：mecache,ehcache,redis:no SQL 数据库（大型网站：）
实体类：*/
public class Contact implements Serializable {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
