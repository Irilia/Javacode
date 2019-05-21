package TestThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class TestCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        int tikle = 20;
        for (int i = 0; i < 20; i++) {
            System.out.println("当前线程："+Thread.currentThread().getName()+"剩余"+tikle--+"票");
        }
        return "票卖完了";
    }
}
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable tc1 = new TestCallable();
        FutureTask ft1 = new FutureTask(tc1);
        Thread thread = new Thread(ft1);
        Thread thread1 = new Thread(ft1);
        Thread thread2 = new Thread(ft1);
        thread.start();
        thread1.start();
        thread2.start();
        System.out.println(ft1.get());
    }
}
