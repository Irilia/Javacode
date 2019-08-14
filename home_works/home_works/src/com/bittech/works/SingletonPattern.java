package com.bittech.works;

/*

单例：一个类只有一个实例化对象
1. 构造方法私有
2. 提供一个静态方法用于返回对象
3. 多次调用静态方法返回的对象必须是同一个
4. 定义一个静态的属性对象表示当前类的对象

手写单例不心慌：https://blog.51cto.com/aiilive/2164281
 */
public class SingletonPattern {

}

//饿汉式单例
//立即实例化
class SingletonA {

    private static final SingletonA INSTANCE = new SingletonA();

    private SingletonA() {
    }

    public static SingletonA getInstance() {
        return INSTANCE;
    }
}

//懒汉式单例
//延迟实例化对象
class SingletonB {
    private static SingletonB singletonB;

    private SingletonB() {

    }

    //有问题，多线程环境下有线程安全问题
    public static SingletonB getInstance() {
        if (singletonB == null) {
            singletonB = new SingletonB();
        }
        return singletonB;
    }
}

//more
//静态内部类，枚举法，双重检查法