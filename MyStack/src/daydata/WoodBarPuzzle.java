package daydata;

import java.util.ArrayList;
import java.util.Scanner;

public class WoodBarPuzzle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            OperatingMode(n,arr);
        }
    }

    public static void OperatingMode(int n,int[][] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i][0] == 1){
                list.add(arr[i][1]);
            }else {
                list.remove(new Integer(arr[i][1]));
            }
            if(CanNotFromSimplePolygon(list)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean CanNotFromSimplePolygon (ArrayList<Integer> list){
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int temp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len-1; j++) {
                sum += list.get(j);
            }
            if(sum <= temp) {
                list.add(i,temp);
                return false;
            }
            list.add(i,temp);
        }
        return true;
    }
}
