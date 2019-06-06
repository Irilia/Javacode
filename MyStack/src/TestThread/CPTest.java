package TestThread;
class Good{
    @Override
    public String toString() {
        return "Good{" +
                "count=" + count +
                ", Name='" + Name + '\'' +
                '}';
    }

    int count = 0;
    String Name;
    public synchronized void set() {
        if(count!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"生产"+this);
        count++;
        this.notify();
    }
    public synchronized void get() {
        if(count!=1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
    }
}

class Consumer implements Runnable{

    public Consumer(Good good) {
    }

    @Override
    public void run() {
        
    }
}
class Producer implements Runnable{

    public Producer(Good good) {
    }

    @Override
    public void run() {
        
    }
}
public class CPTest {
    Good good = new Good();
    Producer producer = new Producer(good);
    Consumer consumer = new Consumer(good);
    Thread thread = new Thread();

}
