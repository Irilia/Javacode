package daydata;
//编译失败，成员方法不能拥有静态域
public class Test2 {
    public int aMethod() {
        //static int i = 0;
        //i++;
        //return i;
        return 0;
    }
    public abstract class Myclass {
        public int c = 5;
        //c = c+3;
        public void method(){}
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.aMethod();
        int j = test2.aMethod();
        System.out.println(j);
    }
}
