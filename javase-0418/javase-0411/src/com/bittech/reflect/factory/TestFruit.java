package com.bittech.reflect.factory;

public class TestFruit {

    public static void main(String[] args) {
        Fruit fruit = FruitFactory
                .getFruit("com.bittech.reflect.factory.Orange");
        if (fruit != null) {
            fruit.eat();
        } else {
            System.out.println("FruitFactory 创建Fruit对象失败");
        }
    }
}
