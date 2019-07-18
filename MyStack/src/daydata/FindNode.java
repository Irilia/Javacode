package daydata;

import java.util.Scanner;

public class FindNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(getLCA(a,b));
    }
    public static int getLCA(int a, int b) {
        return a==b? a : a>b? getLCA(a>>1,b):getLCA(a,b>>1);
    }
}
