package daydata;


import java.util.Scanner;

public class TestWaterBottle {
    public int TheNumberOfButtle(int n){
        int drink = 0;
        int remain = 0;
        int sum = 0;
        if(n>=1 && n<=100){
            while(n > 2){//10  4
                drink = n/3;//3  4
                remain = n%3;//1  1
                sum += drink;
                n = remain+drink;//4  5
            }
            if(n == 2){
                return sum+1;
            }

        }
        return sum;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            TestWaterBottle waterBottle = new TestWaterBottle();
            System.out.println(waterBottle.TheNumberOfButtle(n));
        }

    }
}
/*
import java.util.Scanner;
public class TestWaterBottle{
    public static boolean isHuiWen(String ss) {
        int l = 0;
        int r = ss.length()-1;
        while(l<r){
            if(ss.charAt(l) == ss.charAt(r)) {
                r--;
                l++;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str1 = sn.nextLine();
        String str2 = sn.nextLine();
        int count = 0;
        for(int i = 0;i <= str1.length();i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            if(isHuiWen(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}*/
