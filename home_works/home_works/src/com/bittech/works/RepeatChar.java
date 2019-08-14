package com.bittech.works;

public class RepeatChar {

    public static char findRepeatThreeTimesChar(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException("value must be not null/empty");
        }
        //value -> 字母数字
        //Java的集合框架
        // char -> count
        // e  -> 3
        // a  -> 2
        //255
        int[] counter = new int[255];
        //a -> 97 -> counter[97]=1
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //a-z A-Z
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                counter[c]++;
            }
            if (counter[c] == 3) {
                return c;
            }
        }
        throw new RuntimeException("Not found three times char");
    }


    public static void main(String[] args) {
        System.out.println(findRepeatThreeTimesChar("Have you never gone shopping."));
//        System.out.println(findRepeatThreeTimesChar(""));
//        System.out.println(findRepeatThreeTimesChar(null));
        System.out.println(findRepeatThreeTimesChar("Hello Java"));
    }
}
