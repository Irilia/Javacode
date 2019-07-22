package daydata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteTwoStringOfSame {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        char[] arr2 = str2.toCharArray();
        char[] arr1 = str1.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            list.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(list.contains(arr2[i])){
                char c = arr2[i];
                list.remove(c);
            }
        }
        System.out.println(list);
    }
}
