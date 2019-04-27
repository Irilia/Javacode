package com.Irilia.factory;
/**
 * 抽象工厂模式
 * 1.多个抽象产品类
 * 2.具体产品类
 * 3.抽象工厂类-声明一组返回抽象产品的方法
 * 4.具体工厂类-生成一组具体产品
 * */
//工厂接口
interface ComputerFactory2{
    Computer2 createComputer();
    OperationOS createOperationOS();
}
//电脑接口
interface Computer2{
    //计算机
    void printComputer();
    //操作系统
    OperationOS createOperationOS();
}
//操作系统接口
interface OperationOS{
    void printOperationOS();
}
//具体操作系统类
class Windows10 implements OperationOS{

    @Override
    public void printOperationOS() {
        System.out.println("Windows10操作系统，简单好用");
    }
}
class MacOS implements OperationOS{

    @Override
    public void printOperationOS() {
        System.out.println("MacOS操作系统好用流畅");
    }
}
//具体业务类
class MacComputer2 implements Computer2{

    @Override
    public void printComputer() {
        System.out.println("MacComputer2好看，好用，快");
    }

    @Override
    public OperationOS createOperationOS() {
        return new MacOS();
    }
}
class SurfaceComputer2 implements Computer2{

    @Override
    public void printComputer() {
        System.out.println("SurfaceComputer2屏幕可旋转，好看，轻");
    }

    @Override
    public OperationOS createOperationOS() {
        return new Windows10();
    }
}
//具体工厂类
class MacComputerFactory2 implements ComputerFactory2{

    @Override
    public Computer2 createComputer() {
        return new MacComputer2();
    }

    @Override
    public OperationOS createOperationOS() {
        return new MacOS();
    }
}
class SurfaceComputerFactory2 implements ComputerFactory2{

    @Override
    public Computer2 createComputer() {
        return new SurfaceComputer2();
    }

    @Override
    public OperationOS createOperationOS() {
        return new Windows10();
    }
}
//客户端
class Client2{
    public void buyComputer(Computer2 computer2,OperationOS operationOS){
        computer2.printComputer();
        operationOS.printOperationOS();
    }
}

public class TestabstractFactory {
    public static void main(String[] args) {
        //TestFactoryMethod testFactoryMethod = new TestFactoryMethod();
        /*System.out.println("请输入你想买的电脑");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();*/
        Client2 client2 = new Client2();
        //和工厂方法一样要客户端和工厂类耦合
        ComputerFactory2 computerFactory2 = new MacComputerFactory2();
        client2.buyComputer(computerFactory2.createComputer(),computerFactory2.createOperationOS() );
    }
}
