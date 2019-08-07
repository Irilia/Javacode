package com.irilia.FactoryDesignPattern;
/*
* 1.多个产品抽象类
* 2.多个具体的产品类
* 3.工厂组抽象类
* 4.具体工厂业务组类*/
//卖电脑，卖处理器
interface Computer3 {
    void printComputer3();
}
interface OperatingSystem{
    void printOperatingSystem();
}
//电脑的具体类
class MacBookCumputer implements Computer3{
    @Override
    public void printComputer3() {
        System.out.println("This is a MacBookComputer");
    }
}
class SurfaceBookComputer implements Computer3{
    @Override
    public void printComputer3() {
        System.out.println("This is a SurfaceBookComputer");
    }
}
//处理器的具体类
class Windows8System implements OperatingSystem{
    @Override
    public void printOperatingSystem() {
        System.out.println("This is a Windows8System");
    }
}
class MacOsSystem implements OperatingSystem{
    @Override
    public void printOperatingSystem() {
        System.out.println("This is a MacOsSystem");
    }
}
//抽象工厂的业务组
interface ProductionFactory{
    Computer3 creatComputer3();
    OperatingSystem creatOperation();
}
//具体工厂的业务组
class AppleFactory2 implements ProductionFactory{
    @Override
    public Computer3 creatComputer3() {
        return new MacBookCumputer();
    }
    @Override
    public OperatingSystem creatOperation() {
        return new MacOsSystem();
    }
}
class MSFactory2 implements ProductionFactory{
    @Override
    public Computer3 creatComputer3() {
        return new SurfaceBookComputer();
    }
    @Override
    public OperatingSystem creatOperation() {
        return new Windows8System();
    }
}
public class AbstractFactory {
    public void buyComputer(Computer3 computer3,OperatingSystem operatingSystem){
        computer3.printComputer3();
        operatingSystem.printOperatingSystem();
    }
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();
        ProductionFactory productionFactory = new AppleFactory2();
        Computer3 computer3 = productionFactory.creatComputer3();
        OperatingSystem operatingSystem = productionFactory.creatOperation();
        abstractFactory.buyComputer(computer3,operatingSystem);
    }
}
