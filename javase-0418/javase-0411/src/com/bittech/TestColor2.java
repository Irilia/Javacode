package com.bittech;


public class TestColor2 {

    public static void main(String[] args) {
        IColor iColor = Color2.RED;
        //Color2 extends Enum implements IColor
        //((Color2) iColor).print();
        iColor.printValue();

    }
}

/*
枚举：
1. 枚举类是特殊的类，使用enum关键字修饰
2. 枚举类中定义常量，类型是枚举类的类型，枚举常量，通过枚举类.常量名访问
3. 枚举类不能通过new实例化对象
4. 枚举类提供了有参数的构造方法，枚举常量定义时需要指定参数值
5. 任何地方使用同名的枚举常量时，它们是同一个对象
6. 通过枚举类的values静态方法获取所有的枚举常量
7. 枚举常量（对象）
      name() 获取常量名
      ordinal()获取的是常量定义的顺序下标（0开始）, 开发中不需要依赖该值
8. 通过枚举类的valueOf静态方法，参数传入枚举常量的名称，获取枚举常量（对象）
   如果不存在，抛出异常（运行时异常）
9. 枚举类（隐式）继承自java.lang.Enum抽象类，因此不能在继承其它类
10.枚举类可以实现接口
11.switch支持枚举类型
 */
interface IColor {
    void printValue();
}

enum Color2 implements IColor {

    RED("红色"),
    YELLOW("黄色"),
    GREEN("绿色"),
    BLUE("蓝色");

    private String title;

    Color2(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public String print() {
        return "#" + this.getTitle();
    }

    @Override
    public String toString() {
        return "Color2{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public void printValue() {
        System.out.println(this.getTitle());
    }
}
