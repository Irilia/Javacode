package daydata;

import java.util.Scanner;

public class TestKth {
    public int FindKth(int[] a,int n,int k){
        if(a == null && n <= 0 && k <= 0){
            throw new UnsupportedOperationException("input is illegal");
        }
        int last = a.length-1;
        int first = 0;
        int tmp = a[first];
        while(first != last){
            if(a[last] < tmp){
                a[first] = a[last];
                first++;
            }else{
                last--;
            }
        }
        a[last] = tmp;
        int c = a.length;

        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,6,1,2,3,4,7};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        TestKth kth = new TestKth();
        System.out.println(kth.FindKth(a,n,k));

    }
}
