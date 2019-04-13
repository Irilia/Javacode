package com.bit.main;
import java.util.Date;
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        /*//正向处理
        Date date = new Date();
        //取得Date类的Class对象
        Class<Date> cls = (Class<Date>) date.getClass();
        System.out.println(cls);*/
        /*System.out.println(Date.class);
        Class cls1 = Class.forName("java.util.Date");
        System.out.println(cls1);*/
        /*Class<Date> cls = Date.class;
        //通过反射取得Date类对象
        Date date = cls.newInstance();
        System.out.println(date);*/

        Class<Test> cls = Test.class;
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getSuperclass());
    }
}

/*
class ComputerFactory{
    public static IComputer getInstance(String computerClass){
        try{
            Class<?> cls = Class.forName(computerClass);
            IComputer computer = (IComputer) cls.newInstance();
            return computer;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
        return null;
    }
}*/
