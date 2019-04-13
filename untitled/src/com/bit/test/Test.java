package com.bit.test;

/*interface ISubject{
    void test();
}*/

/*interface ISubject<R>{
    R switchPara();
}*/
interface ISubject<R,PI,PS>{
    R createPerson(PI pi,PS ps);
}
class Person{
    private Integer age;
    private String name;

    public Person(Integer age,String name){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "Person{" +
                "age="+ age +
                "name="+ name +'\'' +
                "}";
    }
}
public class Test{
    public static void main(String[] args) {
        ISubject<Person,Integer,String> subject =
                Person :: new;
        //等同于new Person(18,"jiujiu");
        Person per = subject.createPerson(18,"jiujiu");
        System.out.println(per);
        //内部类
       /* ISubject subject = new ISubject() {
            @Override
            public void test() {
                System.out.println("helloworld");
            }
        };
        subject.test();
        //函数式编程
        //-
        ISubject subject2 = () -> System.out.println("helloworld") ;
        subject.test();*/
    }
}