package TestThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThreads implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+","+i);
        }
    }
}

public class TestThreads {
    public static void main(String[] args) {
        MyThreads myThreads = new MyThreads();
        //手工创建线程池
        ExecutorService executorService =
                new ThreadPoolExecutor(3,5,2000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            executorService.execute(myThreads);
        }
    }
}
