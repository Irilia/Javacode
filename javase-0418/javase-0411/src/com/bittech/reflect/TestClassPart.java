package com.bittech.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestClassPart {

    public static void codePart1() {
        Class classz = Message.class;

        //获取类的包名
        Package pg = classz.getPackage();
        System.out.println(pg.getName());
        System.out.println(pg.toString());

        //获取类的名称
        //包名+类名 = 类的全限定名
        System.out.println(classz.getName());
        //类名
        System.out.println(classz.getSimpleName());

        //父类(extends)
        Class superClass = classz.getSuperclass();
        System.out.println("父类的名称：" + superClass.getName());
        System.out.println("父类的包名：" + superClass.getPackage().getName());

        //接口(implements)
        Class[] interfacesClass = classz.getInterfaces();
        for (Class cls : interfacesClass) {
            System.out.println("接口名称：" + cls.getName());
        }
    }

    public static void main(String[] args) {
        Class classz = Message.class;
        //获取classz的所有构造方法
        Constructor[] constructors = classz.getConstructors();
        for (Constructor constructor : constructors) {
            //1. 遍历数组，通过StringBuilder拼接
            //2. Arrays
            Class[] parameterTypes = constructor.getParameterTypes();
            String parameters = Arrays.toString(parameterTypes);
            System.out.println(constructor.getName() + "(" + parameters + ")");
        }

        System.out.println("--------");

        //获取指定的构造方法
        try {
            Constructor constructor = classz.getConstructor(String.class, Integer.class);
            System.out.println(constructor);

            //通过构造方法对象获取实例化对象
            Object object = constructor.newInstance("zhangsan", 20);
//            System.out.println(object);
//            System.out.println(object.getClass());
            Message message = (Message) object;
            System.out.println(message);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}


interface IMessage {

}

interface OperatorSystem {

}

class ChatMessage {

}

class Message extends ChatMessage implements IMessage, OperatorSystem {
    private String name;
    private Integer age;

    //()
    public Message() {

    }

    //(String,Integer)
    public Message(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //(Integer,String)
    public Message(Integer age, String name) {
        this(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}