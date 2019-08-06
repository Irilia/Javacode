package multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread id = %s%n",Thread.currentThread().getId());
    }
}
