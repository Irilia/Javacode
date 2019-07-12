package daydata;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String[] sch = str.split("<br/>");
            char[] chars = sch[0].toCharArray();//原测试用例
            char[] bronke = new char[chars.length];
            int len = chars.length;
            List<String> list = Arrays.asList(sch[1]);//坏的测试用例
            int j = 0;
            //List<String> list2 = Arrays.asList(sch[1]);
            for (int i = 0; i < len; i++) {
                if(list.contains(chars[i])) {
                    continue;
                }else {
                    bronke[j++] = chars[i];
                }
            }
            for (int i = 0; i < bronke.length; i++) {
                System.out.print(bronke[i]+" ");
            }

        }

    }
}
