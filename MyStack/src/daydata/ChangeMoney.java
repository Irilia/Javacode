package daydata;

public class ChangeMoney {
    public static void main(String[] args) {
        int x = 30*10;
        x = x*10000*100;
        System.out.println(x+"分");
        double y = Math.pow(2,31);
        y = y/10000/100;
        System.out.println(y+"万元");
    }
}
