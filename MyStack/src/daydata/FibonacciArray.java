package daydata;

import java.util.Scanner;

public class FibonacciArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        while(b<n){
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        System.out.println((b-n)>(n-a)?(n-a):(b-n));
    }
}
