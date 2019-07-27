package DynamicProgramming;

import daydata.FibonacciArray;

import java.util.Scanner;

public class TestFibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Fibonacci(n));
    }
    public static int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }
        int[] fbi = new int[n+1];
        fbi[1] = 1;
        fbi[2] = 1;
        for (int i = 2; i <= n-1;i++) {
            fbi[i] = fbi[i-1]+fbi[i-2];
        }
        return fbi[n];
        /*int fn1 =1, fn2 = 1;
        int ret = 0;
        if(n <= 0){
            return 0;
        }
        if(n == 1||n == 2){
            return 1;
        }
        for(int i = 3;i <= n; i++) {
            ret = fn1+fn2;
            fn2 = fn1;
            fn1 = ret;
        }
        return ret;*/
    }
}
