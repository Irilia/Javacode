package TestThread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int tikle = 100;
        for (int i = 0; i < 100; i++) {
            System.out.println("当前线程："+Thread.currentThread().getName()+"剩余"+tikle--+"票");
        }
        return "票卖完了";
    }
}
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable tc1 = new TestCallable();
        FutureTask ft1 = new FutureTask(tc1);
        FutureTask ft2 = new FutureTask(tc1);
        FutureTask ft3 = new FutureTask(tc1);
        Thread thread1 = new Thread(ft1,"A");
        Thread thread2 = new Thread(ft2,"B");
        Thread thread3 = new Thread(ft3,"C");
        thread1.start();
       // System.out.println(ft1.get());
        thread2.start();
        //System.out.println(ft2.get());
        thread3.start();
        //System.out.println(ft3.get());



    }
}
