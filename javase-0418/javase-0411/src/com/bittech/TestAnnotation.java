package com.bittech;

public class TestAnnotation {

    public static void main(String[] args) {

        Son son = new Son();
        System.out.println(son);//toString();
        son.printInfo();
        son.printSon();
    }

}

class Father {

    public void balance() {

    }

    @Override
    public String toString() {
        System.out.println("这是father类");
        return "father";
    }
}

class Son extends Father {

    @Override
    public String toString() {
        System.out.println("这是Son类");
        return "Son";
    }

    @Override
    public void balance() {
        //TODO
    }

    //v1.0 建议使用 printSon 替换它
    @Deprecated
    public void printInfo() {
        System.out.println("打印Son");
    }

    //v1.2
    public void printSon() {
        System.out.println("打印Son !!!");
    }
}
