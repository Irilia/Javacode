package com.irilia.FactoryDesignPattern;
import java.util.Scanner;
/*1.一个抽象产品类(接口：用来生产产品)
  2.具体产品类
  3.工厂
* */
interface Computer{
    void printComputer();
}
class MacBookComputer implements Computer{
    @Override
    public void printComputer() {
        System.out.println("This is a MacBookComputer");
    }
}
class SurfaceBookCmputer implements Computer{
    @Override
    public void printComputer() {
        System.out.println("This is a SurfaceBookCmputer");
    }
}
class Factory{
    public static Computer MakeComputer(String type){
        Computer computer = null;
        if(type.equals("macbookComputer")){
            computer = new MacBookComputer();
        }else if(type.equals("surfaceBookComputer")){
            computer = new SurfaceBookCmputer();
        }
        return computer;
    }
}
//客户端
public class SimpleFactory {
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();
        simpleFactory.buyComputer(Factory.MakeComputer(type));
    }
}
