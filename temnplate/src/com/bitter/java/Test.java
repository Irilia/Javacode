package com.bitter.java;

class MyClass<T> {
    private T t;
    public T getT(){
        return t;
    }

}


/*class MyClass<T> {
    private T t;
    private T t;

}*/
/*class MyClass{
    public static <T> void fun(T t){
        System.out.println(t);
    }
    public <T> T fun(T t){
        System.out.println(t);
    }
}

class MyClass<T>{
    private T t;
    public <T> T fun(T t){
        System.out.println(t);
    }
}*/


/*class Point{
    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    private Object x;
    private Object y;
}*/
public class Test {
    //fun只能接收String类型的myclass
    public static void fun(MyClass<Integer> myClass){

    }
    public static void fun(MyClass<String> myClass) {
        System.out.println(myClass.getT());
    }
    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>();
        fun(myClass);

        /*MyClass.fun("123");
        MyClass.fun(123);
*/
       /* MyClass<String> class1 = new MyClass<String>();
        MyClass<Integer> class2 = new MyClass<Integer>();
        new Point<String>();
*/
       /* Point point1 = new Point();
        point1.setX(10);
        point1.setY(20);
        int x = (int) point1.getX();
        int y = (int) point1.getY();
        System.out.println("x = "+x);
        System.out.println("y = "+y);*/

        /*System.out.println(sum(new int[]{1,3,5}));
        System.out.println(sum(new int[]{1,3,5,7}));
        System.out.println(sum(new int[]{1,3,5,7,9}));*/
/*
        System.out.println(sum(1,3,5));
        System.out.println(sum(1,3,5,7));
        System.out.println(sum(1,3,5,7,9));*/


    }
//设计一个方法，可以接收任意长度的整型并依次叠加，返回叠加结果
    /*public static int sum(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }*/

    /*public static int sum(int ...  data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }*/
}
