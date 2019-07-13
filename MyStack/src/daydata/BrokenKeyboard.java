package daydata;

import java.util.*;

public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<Character> hashSet = new HashSet<>();
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String res1 = str1.toUpperCase();
        String res2 = str2.toUpperCase();
        //将错误的句子换成字符存进hashSet集合中，并且不重复存储
        for (int i = 0; i < res2.length(); i++) {
            char c = res2.charAt(i);
            hashSet.add(c);
        }
        //判断hashSet里面包不包含正确的句子里的字母
        for (int i = 0; i < res1.length(); i++) {
            if(!hashSet.contains(res1.charAt(i))) {
                linkedHashSet.add(res1.charAt(i));
            }
        }
        //输出
        for(Character c :linkedHashSet) {
            System.out.print(c);
        }
    }
}
