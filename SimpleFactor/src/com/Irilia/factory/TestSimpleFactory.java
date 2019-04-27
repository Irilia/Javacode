package com.Irilia.factory;

import java.util.Scanner;

/**
* 简单工厂模式：
 * 1.一个抽象产品类（接口）
 * 2.具体产品类（若干个）
 * 3.一个工厂
 * 4.客户端
**/
//抽象产品类
interface Computer{
    void printComputre();
}
//具体产品类
class MacbookproComputer implements Computer{

    @Override
    public void printComputre() {
        System.out.println("贵，好用，快");
    }
}
//具体产品类
class Lenovo implements Computer{

    @Override
    public void printComputre() {
        System.out.println("便宜，性价比高，好用");
    }
}
//工厂
class ComputerFactory{
    //返回指定电脑的参数
    public static Computer getInstance(String type) {
        Computer computer = null;
        if(type.equals("外星人")){
            computer = new MacbookproComputer();
        }else if(type.equals("联想")){
            computer = new Lenovo();
        }
        return computer;
    }
}
//客户端，让用户选择产品
public class TestSimpleFactory {
    public void buyComputer(Computer computer){
        computer.printComputre();
    }
    public static void main(String[] args) {
        //创建一个客户
        TestSimpleFactory testSimpleFactory = new TestSimpleFactory();
        //客户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想查询的电脑");
        String type = scanner.nextLine();
        //把客户输入的类型传入工厂
        //工厂返回客户查询的类型的对象
        Computer computer = ComputerFactory.getInstance(type);
        //客户买电脑
        testSimpleFactory.buyComputer(computer);
    }

}
