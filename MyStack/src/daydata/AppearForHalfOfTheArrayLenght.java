package daydata;

import java.util.*;
public class AppearForHalfOfTheArrayLenght {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            //用split方法将输入的字符串按空格分割
            String[] strs = str.split(" ");
            //将分割出来的字符串转换成整型
            int[] arr = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int j = 1; j < arr.length; j++) {
                if(arr[j]==num){
                    count++;
                }else if(count>0){
                    count--;
                }else{
                    num = arr[j];
                }
            }
            System.out.println(num);

        }
    }
}
