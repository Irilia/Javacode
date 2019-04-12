package com.bit.test;

public class Test {
    interface IMessage {
        public void print() ; // 这是一个接口，接口中的抽象方法必须由子类覆写。
    }
    public class TestDemo {
        public static void main(String[] args) {
            IMessage message = new IMessage() { // 匿名内部类
                @Override
                public void print() { // 必须编写完整语法
                    System.out.println("Hello World");
                }
            };
            message.print();
        }
    }
}
