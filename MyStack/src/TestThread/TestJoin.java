package TestThread;

import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyThread1 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("主线程睡眠前的时间");
            TestJoin.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠结束的时间");
            TestJoin.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 mt = new MyThread1();
        Thread thread = new Thread(mt,"子线程A");
        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
        System.out.println("代码结束");
    }
    public static void printTime(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        System.out.println(time);
    }
}
