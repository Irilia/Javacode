package daydata;

import java.util.Scanner;

/*public class TheNumberOfZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for (int i = n; i >= 5; i--) {
            int tmp = i;
            while (tmp%5==0) {
                count++;
                tmp /= 5;
            }
        }
        System.out.println(count);
    }
}*/
public class TheNumberOfZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        System.out.println(TheNumber(n));
        long s = TheNumber(n);
        int count = 0;
        while(s%10 == 0) {
            count++;
            s = s/10;
        }
        System.out.println(count);
    }
    public static long TheNumber(long n) {
        if(n==0){
            return 0;
        }
        while(n!=1){
           return  n*TheNumber(n-1);
        }
        return 1;
    }
}
