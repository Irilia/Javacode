package cases;



import annotions.Benchmark;
import annotions.Measurement;
import annotions.Warmup;


import java.util.Arrays;
import java.util.Random;

@Measurement(iterations = 10,group = 3)
public class Sortcases implements Cases {

    public static void quicksort(int[] arr){
        int l=0;
        int r=arr.length-1;
        if(arr.length<1) return;
        else quicksortInternal(arr,l,r);
    }

    private static void quicksortInternal(int[] arr1, int s, int e) {
        if (s >= e) {
            return;
        }
        int q = partition2(arr1, s, e);
        quicksortInternal(arr1, s, q - 1);
        quicksortInternal(arr1, q + 1, e);
    }
    private  static  int partition2(int[] arr,int l,int r){
        int randomIndex=(int)(Math.random()*(r-l+1)+l);
        swap(arr,l,randomIndex);
        int pivot=arr[l];
        int i=l+1;
        int j=r;
        while (true){
            while(i<=r&&arr[i]<pivot) i++;
            while (j>=l+1&&arr[j]>pivot) j--;
            if(i>j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }


    @Benchmark
    @Warmup(iterations = 200)
    public static void testQuickSort(){
        int[] a=new int[100000];
        Random random=new Random(20190727);
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(10000);
        }
        quicksort(a);
    }
    @Benchmark
    public static void testArraysSort(){
        int[] a=new int[100000];
        Random random=new Random(20190727);
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(10000);
        }
        Arrays.sort(a);
    }
}



