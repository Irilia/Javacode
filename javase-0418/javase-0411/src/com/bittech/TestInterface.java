package com.bittech;

public class TestInterface {

    public static void main(String[] args) {
        IMessage qq = new QQMessage();
        qq.print();
        qq.fun();

        IMessage.message();

    }
}

/*
接口
1. interface修饰
2. 定义常量，抽象方法，默认的普通方法，静态方法
3. 接口可以继承多个接口
4. 子类可以实现多个接口
5. 接口是面向对象三大特性中的多态的体现
 */
interface IMessage {


    default void fun() {
        System.out.println("聊天工具");
    }

    static void message() {
        System.out.println("IMessage 静态方法");
    }

    void print();

}

class QQMessage implements IMessage {

    @Override
    public void print() {
        System.out.println("这是QQ聊天工具");
    }

    @Override
    public void fun() {
        System.out.println("沟通多一点");
    }
}

class MsnMessage implements IMessage {

    @Override
    public void print() {
        System.out.println("这是MSN聊天工具");
    }
}




