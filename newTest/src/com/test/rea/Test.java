package com.test.rea;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Animal{
    private Double weight;
    public Animal(){}
    private Animal(Double weight){
        this.weight = weight;
    }
}
class Person extends Animal{
    private Integer age;
    private String name;
    //无参构造方法
    //public Person(){ }

    //default权限的构造方法
    /*Person(Integer age){
        this.age = age;
    }*/

    //private权限的构造方法
    private Person(Integer age,String name){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> cls = Person.class;
        Constructor constructor = cls.getDeclaredConstructor(Integer.class,String.class);
        //Person per = cls.newInstance();
        //动态破坏封装,仅在一次jvm进程中
        constructor.setAccessible(true);
        Person per = (Person) constructor.newInstance(18,"me");
        System.out.println(per);

        /*Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------");
        constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }*/
       /* Constructor<Person> constructor = cls.getConstructor();*/
       // Constructor constructor = cls.getDeclaredConstructor(Integer.class,String.class);
        /*for(Constructor constructor : constructors){
            System.out.println(constructor);
        }*/
        /*System.out.println(constructor);*/
    }
}
