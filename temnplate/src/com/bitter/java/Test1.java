package com.bitter.java;

interface ISubject<T>{
    void fun(T t);
}

interface IColor{
    String getTitle();
}
enum Color implements IColor{
    //默认通过无参构造产生
    RED("红"),BLUE("蓝"),YELLOW("黄");
    private String title;
    private Color(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

class SubjectImpl implements ISubject<String>{

    @Override
    public void fun(String s) {

    }
}
/*
class SubjectImpl<T> implements ISubject<T>{

    @Override
    public void fun(T s) {

    }
}

public class Test1 {
    public static void main(String[] args) {

    }
*/
}
