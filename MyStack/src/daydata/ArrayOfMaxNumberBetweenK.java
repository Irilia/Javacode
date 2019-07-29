package daydata;

import java.util.Arrays;

public class ArrayOfMaxNumberBetweenK {
    public static void main(String[] args) {
        int[] A = {2, 7, 3, 1, 1, 5};
        int n = 6;
        System.out.println(findMaxGap(A,n));
    }
    public static int findMaxGap(int[] A, int n) {
        int k = n-2;
        int[] ret = new int[n-1];
        for(int i = 0; i <= k; i++){
            int[] left = new int[i];
            int[] right = new int[n-k];
            while(i<=k){
                left[i] = A[i];
            }
            for(int j = i+1;j<=n-1;j++){
                right[j] = A[j];
            }
            int a = 0;
            int tmp1 = left[a];
            for(;a<left.length;a++){
                if(left[a]>left[a+1]){
                    tmp1 = left[a+1];
                }
            }
            int b = 0;
            int tmp2 = left[b];
            for(;b<right.length;b++){
                if(left[b]>left[b+1]){
                    tmp2 = left[b+1];
                }
            }
            ret[i] = Math.max(tmp1,tmp2);
        }
        Arrays.sort(ret);
        return ret[n-2];
    }
}
