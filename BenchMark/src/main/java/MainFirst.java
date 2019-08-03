public class MainFirst {
    private static String testStringAdd() {
        String s = " ";
        for (int i = 0; i < 10; i++) {
            s += i;
        }
        return s;
    }

    private static String testStringBuildrtAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int iterations = 100;
        int group = 5;
        System.out.println("testStringBUilderAdd:");
        for (int i = 0; i < group; i++) {
            long t1 = System.nanoTime();
            for (int j = 0; j < iterations; j++) {
                testStringBuildrtAdd();
            }
            long t2 = System.nanoTime();
            System.out.printf("第%d次试验：耗时：%d%n",i,t2-t1);
        }

        System.out.println("字符串相加:");
        for (int i = 0; i < group; i++) {
            long t1 = System.nanoTime();
            for (int j = 0; j < iterations; j++) {
                testStringAdd();
            }
            long t2 = System.nanoTime();
            System.out.printf("第%d次试验：耗时：%d%n",i,t2-t1);
        }
    }
}
