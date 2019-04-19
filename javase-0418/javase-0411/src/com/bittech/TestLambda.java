package com.bittech;

/*
Lambda表达式/函数编程
1. 函数接口：
   专门为函数编程而生，有且只有一个抽象方法，采用@FunctionalInterface标识
2. (参数名列表) -> { 实现体 }
   eg : 无参数  ()->{ }
   eg : 实现体有且只要一条命令（语句） { } 可以省略
   eg : 实现体有且只有一条命令，并且作为返回值 return {} 可以省略
3. Lambda表达式中：参数名不要和变量名重名； 实现体用使用的外部变量隐式final修饰
 */
public class TestLambda {

    public static void code1() {
        //1.定义一个普通类，实现IMessage2接口，实现抽象方法
        //2.通过匿名内部类，创建一个对象
        IMessage2 iMessage2 = new IMessage2() {
            @Override
            public void print() {
                System.out.println("Imessage2 print ");
            }
        };
        iMessage2.print();
    }

    public static void code2() {
        IMessage2 iMessage2 = () -> System.out.println("Imessage2 print ");
        iMessage2.print();

//        IMessage3 iMessage3 = () -> {
//            String a = "hello";
//            String b = "world";
//            return a + b;
//        };

        IMessage3 iMessage3 = () -> {
            return "hello " + "world";
        };
        System.out.println(iMessage3.info());
    }

    public static void code3() {
        //面向对象
//        IMessage4 iMessage4 = new IMessage4() {
//            @Override
//            public int add(int x, int y) {
//                return x+y;
//            }
//        };
//        int z = iMessage4.add(3,5);
//        System.out.println(z);

        //函数编程
//        IMessage4 message4 = (x, y) -> {
//            //TODO more code
//            return x + y;
//        };
//        System.out.println(message4.add(4, 5));
        int sum = 30;
        IMessage4 message4 = (a, b) -> {
            //TODO more code
            return a + b;
        };
        System.out.println(message4.add(4, 5));
    }


    public static void code4() {
        //定义  返回值 方法名 (参数列表)
        //使用  方法名(参数值列表)
        //函数    y   = f(x)
        //方法引用：  面向对象中的方法  =  函数(函数接口 类  一个方法)

        //1.静态方法引用
        // x -> y  函数名 IUtil1
        //String.valueOf(i) 起一个别名
        //
//        IUtil1<Integer, String> iutil1 = (i) -> {
//            return String.valueOf(i);
//        };
        //打通了面向对象 和 函数的关系
        IUtil1<Integer, String> iUtil1 = String::valueOf;
        System.out.println(iUtil1.convert(20));

        // y = f(x)
        // x = g(z)
        // y = f(g(z))
        convert(
                (x) -> {
                    return String.valueOf(x);
                }
        );
        convert(
                (x) -> {
                    System.out.println(x);
                    return String.valueOf(x);
                }
        );
        convert(
                String::valueOf
        );

    }

    public static void convert(IUtil1<Integer, String> iUtil1) {
        System.out.println(iUtil1.convert(20));
    }

    public static void code5() {
        //object -> method -> other object
        IUtil2<String> iUtil2 = () -> {
            return "Hello";
        };
        System.out.println(iUtil2.switchParam());

//        "Hello".toUpperCase();

        IUtil2<String> iUtil21 = "Hello"::toUpperCase;
        System.out.println(iUtil21.switchParam());
    }

    public static void code6() {
        IUtil3<String, Integer> iUtil3 = (p1, p2) -> {
            return p1.compareTo(p2);
        };
        int compareRs = iUtil3.compare("Hello", "HEllo");
        System.out.println(compareRs);

        //类引用成员方法
        IUtil3<String, Integer> iUtil31 = String::compareTo;
        System.out.println(iUtil31.compare("Hello", "HEllo"));

    }

    public static void main(String[] args) {

        //FOP：  z  = f(x,y)
        //OOP :  z  = new Z(x,y)
        IUtil4<String, Integer, Person2> iUtil4 = (p1, p2) -> {
            return new Person2(p1, p2);
        };

        Person2 person2 = iUtil4.createObject("zhangsan", 22);
        System.out.println(person2);

        IUtil4<String, Integer, Person2> iUtil41 = Person2::new;
        IUtil5<Person2> iUtil5 = Person2::new;
        Person2 person21 = iUtil41.createObject("Jack", 22);
        Person2 person22 = iUtil5.createObject();
        System.out.println(person21);
        System.out.println(person22);
    }


}

@FunctionalInterface
interface IUtil1<P, R> {
    R convert(P p);
}

@FunctionalInterface
interface IUtil2<R> {
    R switchParam();
}

@FunctionalInterface
interface IUtil3<P, R> {
    R compare(P p1, P p2);
}

//   f(x,y) = z   z = object
@FunctionalInterface
interface IUtil4<P1, P2, R> {
    R createObject(P1 p1, P2 p2);
}

@FunctionalInterface
interface IUtil5<R> {
    R createObject();
}

@FunctionalInterface
interface IMessage2 {
    void print();
}

@FunctionalInterface
interface IMessage3 {
    String info();
}

@FunctionalInterface
interface IMessage4 {
    // z = f(x,y)   f { x + y }
    // y =f(x)
    int add(int x, int y);
}

class Person2 {
    private String name;
    private Integer age;

    public Person2() {
    }

    public Person2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}