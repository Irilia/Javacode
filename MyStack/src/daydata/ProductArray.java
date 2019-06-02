package daydata;

public class ProductArray {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5};
        int[] B = multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]+" ");
        }

    }
    public static int[] multiply(int[] A){
        int[] B = new int[A.length];
        B[0] = 1;
        int tmp = 1;
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i-1]*A[i-1];
        }
        for (int i = B.length-1; i >= 1; i--) {
            tmp *= A[i];
            B[i-1] *= tmp;
        }
        return B;
    }
}
