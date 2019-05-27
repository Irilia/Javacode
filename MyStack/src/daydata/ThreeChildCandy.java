package daydata;

import java.util.Scanner;
public class ThreeChildCandy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        float child1 = (a+c)/2f;
        float child2 = (c-a)/2f;
        float child3 = (d-b)/2f;
        Suolution(child1,child2,child3,a,b,c,d);
    }
    public static int Suolution(float child1,float child2,float child3,int a,int b,int c,int d){
        if((a+b)!=(c-d)) {
            System.out.println("No");
            return -1;
        }
        System.out.print((int)child1+" "+(int)child2+" "+(int)child3+" ");
        return 0;
    }

}
