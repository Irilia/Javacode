package daydata;

import java.util.Scanner;
public class DeleteNumberArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(TheNumber(num));
    }
    public static int TheNumber(int count) {
        if(count == 0) {
            return 0;
        }
        if(count>1000){
            count = 999;
        }
        boolean[] array = new boolean[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }
        //下标
        int index = -1;
        //退出的人数
        int counter = 0;
        //当前报数
        int number = 0;
        while(counter < array.length-1){
            index = (index+1)%array.length;
            if( !array[index]){
                continue;
            }
            number = (number+1)%3;
            if(number == 0){
                array[index] = false;
                counter++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]) {
                return i;
            }
        }
        return 0;
    }
}
/*import java.util.Scanner;
public class DeleteNumberArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            if(n>1000){
                n = 999;
            }
            boolean[] delete = new boolean[n];
            int count = 0;
            int index = 0;
            int num = 0;
            while (count < n) {
                for (int i = 0; i != n; ++i) {
                    if (delete[i] == false) {
                        ++num;
                        if (num == 3) {
                            delete[i] = true;
                            num = 0;
                            ++count;
                            index = i;
                        }
                    }
                }
            }
            System.out.println(index);
        }
    }
}*/
