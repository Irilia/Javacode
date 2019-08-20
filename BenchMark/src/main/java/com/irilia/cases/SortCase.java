package com.irilia.cases;

import com.irilia.annotations.BenchMark;
import com.irilia.annotations.Measurement;
import com.irilia.annotations.WarmUp;

import java.util.Arrays;
import java.util.Random;

@Measurement(iterations = 10,group = 3)
public class SortCase implements Cases {
    //快速排序（三数取中）
    public void quickSort(int[] a) {
        quickSortInternal(a,0,a.length-1);
    }
    //待排序区间是【low，high】
    private void quickSortInternal(int[] a,int low,int high){
        if(high<=low){
            return;
        }
        //基准值最终所在的下标
        int[]  pivotIndex = partation(a,low,high);
        //[low,pivotIndex-1]
        quickSortInternal(a,low,pivotIndex[0]);
        //[pivotIndex+1,high]
        quickSortInternal(a,pivotIndex[1],high);
    }
    private void swap(int[] a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private int[] partation(int[] a,int low,int high){
        int pivot = a[high];
        int less = low;
        int i = low;
        int more = high;
        while(i<more){
            if(a[i] == pivot){
                i++;
            }else if(a[i] < pivot){
                swap(a,i,less);
                i++;
                less++;
            }else {
                while (more > i && a[more] > pivot){
                    more--;
                }
                swap(a,i,more);
            }
        }
        return new int[]{less-1,more};
    }

    //  归并排序
    public void mergeSort(int[] a) {
        mergeSortInternal(a,0,a.length);
    }
    private void mergeSortInternal(int[] a,int low,int high){
        if(high<=low+1){
            return;
        }
        int mid = (low+high)>>1;
        mergeSortInternal(a,low,mid);
        mergeSortInternal(a,mid,high);

        merge(a,low,mid,high);
    }
    private void merge(int[] a,int low,int mid,int high){
        int length = high-low;
        int[] extra = new int[length];
        int i = low;
        int j = mid;
        int k = 0;
        while(i<mid && j<high){
            if(a[i] <= a[j]){
                extra[k++] = a[i++];
            }else {
                extra[k++] = a[j++];
            }
        }

        while (i<mid) {
            extra[k++] = a[i++];
        }
        while (j<high){
            extra[k++] = a[j++];
        }
        System.arraycopy(extra,0,a,low,length);
    }
    /*
    * 1.测快速排序和归并排序的差别
    * 2.    Arrays.sort(Object)--归并排序
    *       Arrays.sort(int)--快速排序
    * 3.用自己实现的归并排序和Arrays.sort()对比
    * 4.TODO：自己实现并发排序（利用多线程里的ForkJoin）和Arrays.parallelSort()对比
    * */
    @BenchMark
    @WarmUp(iterations = 200)
    public void testQuickSort(){
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100000);
        }
        quickSort(a);
    }

    @BenchMark
    public void testMergeSort(){
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100000);
        }
        mergeSort(a);
    }

    @BenchMark
    public void testArraysSort(){
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100000);
        }
        Arrays.sort(a);
    }
}
