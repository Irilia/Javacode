package com.irilia.TemplateDesignPattern;

import java.util.Scanner;

abstract class  CaffeineBeverage{
    //特定的步骤不能被随便更改所以用final修饰
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        //子类决定要不要添加调料
        if(CustomerWantsCondiments()){
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("烧开水");
    }
    void pourInCup(){
        System.out.println("倒进杯子");
    }
    boolean CustomerWantsCondiments(){
        return true;
    }
}

class Tea extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("冲茶叶");
    }

    @Override
    void addCondiments() {
        System.out.println("加柠檬");
    }
}

class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("泡咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("加牛奶");
    }
    //实现钩子方法
    public boolean CustomerWantsCondiments(){
        String answer = getUserInput();
        if(answer.equals("y")){
            return true;
        }else{
            return false;
        }
    }
    private String getUserInput(){
        String answer = null;
        System.out.println("您想在牛奶中加入糖和牛奶吗（y/n）");
        Scanner in = new Scanner(System.in);
        answer = in.nextLine();
        return answer;
    }
}

public class TemplateDesignPatternTest{
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new Coffee();
        tea.prepareRecipe();
        coffee.prepareRecipe();
    }
}