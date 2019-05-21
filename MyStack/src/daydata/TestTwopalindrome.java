
import java.util.Scanner;

public class TestTwopalindrome {
    public static boolean judge(String s){
        int l=0,r=s.length()-1;
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
        String s1,s2;
        Scanner in=new Scanner(System.in);
        s1=in.nextLine();
        s2=in.nextLine();
        int t=0;
        for(int i=0;i<s1.length();i++){
            String ss=s1.substring(0, i)+s2+s1.substring(i);//截取部分字符串
            if(judge(ss)){
                ++t;
            }
            System.out.println(ss);
        }
        if(judge(s1+s2)){
            ++t;
        }
        System.out.println(t);
    }
}
