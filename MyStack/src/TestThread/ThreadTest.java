package TestThread;

class MyThread extends Thread{
    private String  title;
    private int ticket = 20;

    public MyThread(String title) {
        this.title = title;
    }

    public void run(){
        while(ticket > 0){
            System.out.println("当前线程为："+Thread.currentThread().getName()+"剩余票数："+ticket--+"张");
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread();
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        MyThread myThread = new MyThread("A");
        MyThread myThread1 = new MyThread("B");
        MyThread myThread2 = new MyThread("C");


        /*Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);*/
        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
