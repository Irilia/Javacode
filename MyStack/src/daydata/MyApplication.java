package daydata;
//可以编译通过并正确运行
class Test1{
    public static void hello(){
        System.out.println("hello");
    }
}
public class MyApplication {
    public static void main(String[] args) {
        Test1 test1 = null;
        test1.hello();
    }
}
