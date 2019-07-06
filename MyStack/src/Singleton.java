public class Singleton {
    //单例模式上来构造方法私有化
    //只能产生一个对象，私有化限制对象产生
    //唯一一个对象在类的内部产
    private static Singleton SINGLETON;
    private Integer age;
    private String name;
    private Singleton() {
        age = 5;
        name = "zs";
    }
    public static Singleton getInstance() {
        if(SINGLETON ==null) {
            //线程不安全
            synchronized (Singleton.class) {
                if(SINGLETON == null) {
                    SINGLETON = new Singleton();
                }
            }
        }
        return SINGLETON;
    }
}
