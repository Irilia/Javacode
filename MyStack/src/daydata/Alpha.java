package daydata;
//输出BaseBase
class Base{
    Base(){
        System.out.println("Base");
    }
}
public class Alpha extends Base {
    public static void main(String[] args) {
        new Alpha();
        new Base();
    }
}
