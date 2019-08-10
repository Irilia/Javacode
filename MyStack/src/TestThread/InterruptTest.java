package TestThread;
class MyThread3 implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while (flag) {
            try {
                /**
                 * 这⾥阻塞之后,线程被调⽤了interrupte()⽅法，
                 * 清除中断标志，就会抛出⼀个异常
                 * java.lang.InterruptedException
                 */
                Thread.sleep(1000);
                boolean bool = Thread.currentThread().isInterrupted();
                if (bool) {
                    System.out.println("⾮阻塞情况下执⾏该操作。。。线程状态" + bool);
                    break;
                }
                System.out.println("第"+i+"次执⾏，线程名称为:"+Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                System.out.println("退出了");
                /**
                 * 这⾥退出阻塞状态，且中断标志被系统会⾃动清除，
                 * 并且重新设置为false，所以此处bool为false
                 */
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println(bool);
                //退出run⽅法，中断进程
                return;
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3();
        Thread thread1 = new Thread(myThread3,"⼦线程A");
        thread1.start();
        Thread.sleep(3000);
        thread1.interrupt();
        System.out.println("代码结束");
    }
}
