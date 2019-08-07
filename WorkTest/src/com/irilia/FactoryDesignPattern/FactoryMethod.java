package com.irilia.FactoryDesignPattern;
interface Computer2{
    void printComputer();
}
class MacBookComputer2 implements Computer2{
    @Override
    public void printComputer() {
        System.out.println("This is a MacBookComputer");
    }
}
class SurfaceBookCmputer2 implements Computer2{
    @Override
    public void printComputer() {
        System.out.println("This is a SurfaceBookCmputer");
    }
}
interface Factory2{
    Computer2 creatComputer();
}
class MSFactory implements Factory2{
    @Override
    public Computer2 creatComputer() {
        return new SurfaceBookCmputer2();
    }
}
class AppleFactory implements Factory2{
    @Override
    public Computer2 creatComputer() {
        return new MacBookComputer2();
    }
}
public class FactoryMethod {
    public void buyComputer2(Computer2 computer2){
        computer2.printComputer();
    }
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        Factory2 factory2 = new AppleFactory();
        Computer2 computer2 = factory2.creatComputer();
        factoryMethod.buyComputer2(computer2);
    }
}
