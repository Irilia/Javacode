package com.bit.main;

public class RepeatChar {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(findRepeatThreeTimesChar(null));
    }
    public static char findRepeatThreeTimesChar(String value) throws IllegalAccessException {
        if(value == null || value.length() == 0){
            throw new IllegalAccessException("value must be not null/empty");
        }
        //利用字母在数组中是以ASCII码存在的特性来创建一个包含所有字符的数组
        //counter里面默认放的是0，每次有对应ASCII码的字母出现就把对应的数组元素内容加一，
        //当一个字母对应的数字加到3就输出他.
        int counter[] = new int[255];
        //使用toCharArray()将字符串转化为字符数组
        char[] chars =value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if((c>='a'&&c<='z') || (c>='A' && c<='Z') ){
                counter[c]++;
            }
            if(counter[c] == 3){
                return c;
                //return chars[i];
            }
        }
        throw new UnsupportedOperationException("Don't have three number");
    }
}
