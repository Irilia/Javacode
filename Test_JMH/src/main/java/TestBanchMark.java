import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 3)
@Measurement(iterations = 8)

public class TestBanchMark {
 //快速排序（三数取中）
 @BenchmarkMode()
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
}
