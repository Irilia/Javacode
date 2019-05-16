package kinds_of_Sorts;

public class Test1 {
    public static void bubbleSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if(n <= 1) {
            return;
        }else {
            //控制冒泡排序的次数
            //一次冒泡只能确保一个元素到达最终位置
            for (int i = 0; i < n; i++) {
                boolean flag = false;
                for (int j = 0; j < n-i-1; j++) {
                    if(array[j] > array[j+1]) {
                        flag = true;
                        int tmp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = tmp;
                    }
                }
                if(! flag) {
                    System.out.println("当前遍历到第"+i+"次，数据已经有序");
                    break;
                }

            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序总耗时为："+(end-start)+"毫秒");
    }
}
