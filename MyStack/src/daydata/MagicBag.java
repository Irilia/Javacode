package daydata;

import java.util.Scanner;

/*
public class MagicBag {
    static int[] weight;
    static int N;
    static int count=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            N = input.nextInt();
            weight = new int[N+1];
            for (int i = 1; i <= N; i++) {
                weight[i] = input.nextInt();
            }
            count(40,N);
            System.out.println(count);
        }
    }
    public static void count(int s,int n) {
//如果正好装满
        if(s==0) {
            ++count;
            return ;

        }
//是s<0或n<1则不能完成
        if(s<0||(s>0&&n<1))
            return ;
        count(s-weight[n],n-1);
        count(s,n-1);
    }
}
*/

public class MagicBag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sarr = new int[n];
        for (int i = 0; i <n ; i++) {
            sarr[i] = in.nextInt();
        }
        System.out.println(KindsOfWay(n,sarr));
    }
    public static int KindsOfWay(int n, int[] sarr){
        if(n==0) {
            return 0;
        }
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum+= sarr[i];
        }
        if(sum<40){
            return 0;
        }
        int count  = 0;
        for (int i = 0; i < n; i++) {
            if(sarr[i]>=40){
                count++;
            }
            for (int j = i+1; j < n; j++) {
                if(sarr[i] +sarr[j]==40){
                    count++;
                }
            }

        }

        return count;
    }
}
