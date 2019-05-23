package daydata;

import java.util.Scanner;

public class TestTwopalindrome {
    public static boolean judge(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){//取出单个字符
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        int t=0;
        for(int i=0;i<s1.length();i++){
            StringBuilder ss = new StringBuilder(s1);
            ss.insert(i,s2);
            if(judge(ss.toString())){
                t++;
            }

        }

        System.out.println(t);
    }
}
