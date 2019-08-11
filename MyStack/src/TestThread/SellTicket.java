package TestThread;

import java.util.concurrent.Callable;

class TicketsSell implements Runnable {
    private int ticket = 10000;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                if(ticket > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
                }
            }
        }
    }
}

public class SellTicket {
    public static void main(String[] args) {
        TicketsSell t1 = new TicketsSell();
        Thread th1 = new Thread(t1,"黄牛1");
        Thread th2 = new Thread(t1,"黄牛2");
        Thread th3 = new Thread(t1,"黄牛3");
        th1.start();
        th2.start();
        th3.start();
        th1.run();
        th2.run();
        th3.run();
    }

}
