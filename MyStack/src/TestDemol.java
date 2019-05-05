import java.util.Arrays;
import java.util.Random;

public class TestDemol {
    //直接插入排序
    //时间复杂度O（n*n）
    //稳定性：稳定，空间复杂度O（1）
    //如果没有发生跳跃式的交换，就是稳定的
    //如果给的的数据是有序的数据，那么时间复杂度是O（n），越有序越快
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i-1; j >=0 ; j--) {
                if(tmp < array[j]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //希尔排序：
    //希尔排序是对直接插入排序的优化。
    //希尔排序的时间复杂度不好计算，需要进行推导，推导出来平均时间复杂度： O(N^1.3—N^2）
    //稳定性：不稳定
    public static void shell(int[] array,int gap){
        int j;
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            for (j = i-gap; j >=0 ; j--) {
                if(tmp < array[j]){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    public static void shellSort(int[] array){
        //分为5组。3组。1组
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }

    }
    public static void main(String[] args) {
        /*int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000)+1;
        }*/
        int[] array = {10,6,7,1,3,9,4,2};

        mergeSort(array,0,array.length-1);
        System.out.println("=======================");
        System.out.println(Arrays.toString(array));
    }
    //选择排序
    //每一次从待排序的数据元素中选出最小（或最大）的一个元素，
    //存放在序列的起始位置，直到全部待排序的
    //数据元素排完 。
    //时间复杂度：O（n*n）
    //空间复杂度：O（1）
    //稳定性：不稳定
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }


    //一次调整函数,负责把每一颗子树调整为大根堆
    public static void adjust(int[] array,int start,int end){
        int tmp = array[start];
        for (int i = start; i <= end ; ) {
        }

    }
    //堆排序：
    //时间复杂度：O（n*log以2为底的n）
    //空间复杂度：O（1）
    //稳定性：不稳定
    public static void heapSort(int[] array){
        //整棵树都变成大根堆
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjust(array,i,array.length-1);
        }
        //交换
    }

    //快速排序
    public static int partion(int[] array,int low,int high){
        int tmp = array[low];
        while(low < high){
            while((low < high) && array[high] >= tmp){
                high--;
            }
            if(low == high){
                //array[low] = tmp;
                break;
            }else{
                array[low] = array[high];
            }
            while((low<high) && array[low] <= tmp){
                low++;
            }
            if(low == high){
                //array[low] = tmp;
                break;
            }else{
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }
    //递归实现快排
    public static void quick(int[] array,int low,int high){
        if(low == high){
            return ;
        }
        if(high-low+1<= 10){

        }
        int par = partion(array,low,high);
        //递归左边->保证左边有两个数据以上
        if(par>low+1){
            quick(array,low,par-1);
        }
        //递归右边->保证左边有两个数据以上
        if(par<high-1){
            quick(array,par+1,high);
        }
    }
    //时间复杂度：O（n*log以2为底的n）--快排比堆排要快，系数k不同
    //空间复杂度：O（log以2为底的n）--空间浪费在了par，快排有栈溢出的风险，堆排没有
    //稳定性：不稳定
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
    }

    //三数取中法--优化快排
    //针对部分有序的数组
    public static void takeThreeNumber(int[] array,int low,int high){
        //array[mid] <= arr[low] <= array[high];
        int mid = (low+high)>>>1;
        if(array[mid] > array[low]){
            swap(array,low,high);
        }
        if(array[mid] > array[high]){
            swap(array,low,high);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }
    public static void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    //非递归快排
    //使用栈来存放数对，判断par左边和右边是否有两个数据，如果有就把下一次的low和high放进栈里
    public static void quickSort1(int[] array){
        int[] stack = new int[array.length*2];
        int top = 0;
        int low = 0;
        int high  = array.length-1;
        int par = partion(array,low,high);
        while(top > 0){
            high = --top;
            low = --top;
            par = partion(array,low,high);
            //左边有两个数据元素以上
            if(par>low+1){
                stack[top++] = low;
                stack[top++] = par-1;
            }
            //右边有两个数据元素以上
            if(par<high-1){
                stack[top++] = par+1;
                stack[top++] = high;
            }
            //判断栈顶是否为空，如果不为空，取出栈顶的两个元素，然后接着调用partion（）；
            //接着上面的步骤继续执行，一直到栈为空的时候；
        }

    }

    public static void merge(int[] array,int start,int end,int mid){
        int[] tmpArr = new int[array.length];
        int i = start;
        int tmpIndex = start;//指的是tmpArr的下标；
        int start2 = mid+1;//第二个归并段的开始
        while(start <= mid && start2 <= end){
            if(array[start] <= array[start2]){
                tmpArr[tmpIndex++] = array[start++];
            } else{
                tmpArr[tmpIndex++] = array[start2++];
            }
        }
        while(start <= mid) {
            tmpArr[tmpIndex++] = array[start++];
        }
        while(start2 <= end) {
            tmpArr[tmpIndex++] = array[start2++];
        }
        while(i <= end){
            array[i] = tmpArr[i];
            i++;
        }
        System.out.println(Arrays.toString(array));
    }

    //归并排序-递归
    public static void mergeSort(int[] array,int start,int end){
        //终止条件
        if(start == end){
            return;
        }
        int mid = (start+end)>>>1;
        //递归左边
        mergeSort(array,start,mid);
        //递归右边
        mergeSort(array,mid+1,end);
        //合并函数
        merge(array,start,end,mid);
    }
}
