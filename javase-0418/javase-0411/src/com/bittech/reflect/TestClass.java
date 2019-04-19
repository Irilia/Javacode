package com.bittech.reflect;

import javax.xml.crypto.Data;
import java.util.Date;

public class TestClass {


    public static void code1() {
        Date date = new Date();
        //Class 对象    java.util.Date 类
        //Class类对类抽象，Class Object 描述具体一个类

        Class classz1 = date.getClass();

        Class classz2 = Date.class;

        try {
            Class classz3 = Class.forName("java.util.Date");

            System.out.println("1." + classz1);
            System.out.println("2." + classz2);
            System.out.println("3." + classz3);

            System.out.println(classz1 == classz2);
            System.out.println(classz2 == classz3);


            Class classz4 = String.class;
            System.out.println(classz3 == classz4);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Class classz  = Date.class;
        //不获取Class对象，可以通过Class类获取静态属性和方法
        //获取到Class对象，即可访问Class类中定义的成员属性和方法

        try {
            Object object = classz.newInstance();
            Date date = (Date)object;

            Class classz1 = Integer.class;
            Integer integer = (Integer) classz1.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
