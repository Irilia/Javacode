package daydata;

import java.util.Scanner;
public class BoxForCake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int m = w%4;
        int n = h%4;
        int cake1 = (w-m)*(h-n)/2;
        int cakenm = (m*(h-n)/2)+(n*(w-m)/2);
        int cake2 = 0;
        if(m <= 2 && n <= 2){
            cake2 = m*n;
        }else if(m==3&&n<3){
            cake2 = 2*n;
        }else if(n==3&&m<3){
            cake2 = 2*m;
        }else if(n==3&& m==3){
            cake2 = 5;
        }
        System.out.println(cake1+cake2+cakenm);
    }
}
