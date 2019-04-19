package com.bittech.reflect.factory;

public interface Fruit {
    void eat();
}

class Apple implements Fruit {

    @Override
    public void eat() {
        System.out.println(" 吃 苹果");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println(" 吃 橘子");
    }
}

class FruitFactory {

    private FruitFactory() {

    }

    public static Fruit getFruit(String className) {
        try {
            Class classz = Class.forName(className);
            return (Fruit) classz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
