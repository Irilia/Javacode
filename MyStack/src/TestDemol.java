import java.util.Arrays;
import java.util.Random;

public class TestDemol {
    //直接插入排序
    //时间复杂度O（n*n）
    //稳定性：稳定，空间复杂度O（1）
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
    // 希尔排序的时间复杂度不好计算，需要进行推导，推导出来平均时间复杂度： O(N^1.3—N^2）
    //稳定性：不稳定

    //直接插入排序
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
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000)+1;
        }
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
