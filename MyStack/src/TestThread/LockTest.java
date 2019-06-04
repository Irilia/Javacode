package TestThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable{
    private int ticket = 10000;
    private Lock ticketLock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try{
                ticketLock.lock();
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
                }
            }finally {
                ticketLock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
