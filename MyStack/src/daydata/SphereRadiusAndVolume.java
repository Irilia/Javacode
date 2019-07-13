package daydata;

import java.util.Scanner;

public class SphereRadiusAndVolume {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        double j = Math.pow(a-x,2)+Math.pow(b-y,2)+Math.pow(c-z,2);
        double r = Math.sqrt(j);
        double v = (Math.pow(r,3)*Math.acos(-1)*4)/3;
        System.out.printf("%.3f\n",r);
        System.out.printf("%.3f",v);

    }
}
