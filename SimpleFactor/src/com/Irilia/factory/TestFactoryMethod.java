package com.Irilia.factory;

import java.util.Scanner;

/**
 * 工厂方法模式
 * 1.定义一个工厂接口
 * 2.若干具体工厂类
 * 3.定义一个产品接口
 * 4.若干具体产品类
 */
//工厂接口
interface ComputerFactory1{
    Computer1 createComputer();
}
//电脑接口
interface Computer1{
    void printComputer();
}
//具体业务类
class MacComputer implements Computer1{

    @Override
    public void printComputer() {
        System.out.println("好看，好用，快");
    }
}
class SurfaceComputer implements Computer1{

    @Override
    public void printComputer() {
        System.out.println("屏幕可旋转，好看，轻");
    }
}
//具体工厂类
class MacComputerFactory implements ComputerFactory1{

    @Override
    public Computer1 createComputer() {
        return new MacComputer();
    }
}
class SurfaceComputerFactory implements ComputerFactory1{

    @Override
    public Computer1 createComputer() {
        return new SurfaceComputer();
    }
}
//客户端
public class TestFactoryMethod {

    public static void main(String[] args) {
        //TestFactoryMethod testFactoryMethod = new TestFactoryMethod();
        /*System.out.println("请输入你想买的电脑");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();*/
        Client client = new Client();
        ComputerFactory1 computerFactory1 = new MacComputerFactory();
        client.buyComputer(computerFactory1.createComputer());
    }
}
class Client{
    public void buyComputer(Computer1 computer1){
        computer1.printComputer();
    }
}
