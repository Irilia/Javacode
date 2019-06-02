package daydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleDigitsNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
        for (int i = 0; i < chars.length; i++) {
            list.set(chars[i]-'0',list.get(chars[i]-'0')+1);
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>0){
                System.out.println(i+":"+list.get(i));
            }
        }
    }
}
