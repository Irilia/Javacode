package daydata;

import java.util.Scanner;

public class BuyApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(NumberOfBag(a));

    }
    public static int NumberOfBag(int n) {
        if(n%2!=0||n==10||n<6){
            return -1;
        }
        if(n/8==0){
            return n/8;
        }

        return 1+n/8;
    }
}
