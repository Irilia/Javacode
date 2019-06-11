package daydata;

import java.util.Scanner;

public class StringContainas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] p = new String[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextLine();
        }
        String str = in.nextLine();
        StringContainas sc  = new StringContainas();
        boolean[] con = sc.chkSubStr(p,n,str);
        for (int i = 0; i < con.length; i++) {
            System.out.print(con[i]+" ");
        }
    }
    public boolean[] chkSubStr(String[] p, int n, String s) {
            boolean[] con = new boolean[n];
            for(int i = 0;i < n; i++) {
                con[i] = s.contains(p[i]);
            }
            return con;
    }
}
