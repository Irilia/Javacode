package com.Irilia.factory;
/**
 * 代理设计模式
 * 1.提供一个接口，定义业务功能
 * 2.原本的业务类实现接口
 * 3.提供一个代理类来扩展原本的业务类并实现接口，代理类里定义一个接口类型的成员属性来调用原本的业务方法
 * 4.第一：创建原本的业务类对象
 *   第二：创建代理类的对象，构造方法传入业务类对象
 *   第三：使用代理类的对象调用业务功能
 */
//定义业务功能的接口
interface Subject{
    //买电脑
    void buyComputer();
}
//具体的业务实现
class RealSubject implements Subject{

    @Override
    public void buyComputer() {
        System.out.println("购买电脑");
    }
}
//代理类
class ProxySubject implements Subject{
    private Subject target;
    public ProxySubject(Subject target){
        this.target = target;
    }
    @Override
    public void buyComputer() {
        //原有的业务
        this.target.buyComputer();
        //新的业务
        System.out.println("调研，听客服讲解");
        System.out.println("售后");
    }
}
public class TestProxy {
    public static void main(String[] args) {
        //面向接口编程
        //1.面向对象
        //2.企业级开发中地位很重要
        Subject realSubject = new RealSubject();

        System.out.println("扩展之前的业务");
        realSubject.buyComputer();

        System.out.println("扩展之后的业务");
        Subject proxySubject = new ProxySubject(realSubject);
        proxySubject.buyComputer();

        //需求:1.调研，听取客服的讲解。
        //2.买
        //3.售后


    }
}
