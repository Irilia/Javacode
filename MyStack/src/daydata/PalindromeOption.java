package daydata;

import java.util.Scanner;

public class PalindromeOption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sBuffer = new StringBuffer(in.nextLine());
        int n = in.nextInt();
        String str = in.nextLine();
        for (int i = 0; i < n; i++) {
            String[] strs = str.split(" ");
            int index = Integer.parseInt(strs[0]);
            int len = Integer.parseInt(strs[1]);

        }
    }
}
