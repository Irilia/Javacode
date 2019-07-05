package TypeUnit;

import java.util.concurrent.TimeUnit;

public class FinalizeTest {
    private static FinalizeTest test;
    protected void finalize() throws Throwable{
        System.out.println("finalize method execute!");
        test = this;
    }
    public static void main(String[] args) throws InterruptedException {
        test = new FinalizeTest();
        test = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if(test == null){
            System.out.println("No I am dead man");
        }else {
            System.out.println("I am Alive!");
        }
        test = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if(test == null){
            System.out.println("No I am dead man");
        }else {
            System.out.println("I am Alive!");
        }
    }
}
