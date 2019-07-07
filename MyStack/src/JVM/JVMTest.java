package JVM;

public class JVMTest {
    //10个线程并发自增num的值
    private int num = 0;
    public static void main(String[] args) {
        JVMTest jvmTest = new JVMTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    jvmTest.increase();
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(jvmTest.num);
    }
    public void increase() {
        num++;
    }
}
