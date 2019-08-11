package com.irilia.ProxyPattern;
/*1.业务接口
* 2.真实业务类
* 3.代理类*/
interface Business{
    public void buyLipstick();
}
//真实业务类
class RealSubject implements Business{
    @Override
    public void buyLipstick() {
        System.out.println("买一只mac口红");
    }
}
//代理类
class ProxySubject implements Business{
    private Business object;
    public ProxySubject(Business object){
        this.object = object;
    }
    //飞去国外
    public void FlyAbroad(){
        System.out.println("正在飞往美国");
    }
    //邮寄
    public void SendByPost(){
        System.out.println("正在邮寄");
    }
    @Override
    public void buyLipstick() {
        //飞去国外
        this.FlyAbroad();
        //购买
        System.out.println("正在买mac口红");
        //邮寄
        this.SendByPost();
    }
}
public class ProxyPatternTest {
    public void ShoppingMail(Business object){
        object.buyLipstick();
    }
    public static void main(String[] args) {
        ProxyPatternTest client = new ProxyPatternTest();
        client.ShoppingMail(new ProxySubject(new RealSubject()));
    }
}
