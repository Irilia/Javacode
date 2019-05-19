package daydata;

class Test{
    private int data;
    int result = 0;
    public void m(){
        result +=2;
        data += 2;
        System.out.println(result+" "+data);
    }
}

class TreadExample extends Thread{
    private Test mv;
    public TreadExample(Test mv){
        this.mv = mv;
    }
    public void run(){
        synchronized (mv){
            mv.m();
        }
    }
}
public class TreadTest {
    public static void main(String[] args) {
        Test mv = new Test();
        Thread t1 = new TreadExample(mv);
        Thread t2 = new TreadExample(mv);
        Thread t3 = new TreadExample(mv);
        t1.start();
        t2.start();
        t3.start();

    }
}
