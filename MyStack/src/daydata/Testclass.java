package daydata;
//A派生出B，B派生出C，有以下三种申明，都编译通过
public class Testclass {
    public static void main(String[] args) {
        A a0 = new A();
        A a1 = new B();
        A a2 = new C();
    }
}
class A{

}

class B extends A{

}

class C extends B{

}