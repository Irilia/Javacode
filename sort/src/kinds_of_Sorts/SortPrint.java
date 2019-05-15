package kinds_of_Sorts;

import java.util.Random;

public class SortPrint {
    public static void printArray(int[] array) {
        for(int i:array) {
            System.out.println(i+" ");
        }
    }
    //随机生成若干个元素的数组
    //n--要生成的数组长度
    //rangeL----数组左边界
    //rangeR---数组右边界
    public static int[] generateArray(int n,int rangeL,int rangeR) {
        int[] array = new int[n];
        if(rangeL >rangeR) {
            throw new UnsupportedOperationException("范围非法");
        }else {
            for (int i = 0; i < n; i++) {
               array[i] = new Random().nextInt((rangeR-rangeL+1)+rangeL);
            }
            return array;
        }
    }
}
