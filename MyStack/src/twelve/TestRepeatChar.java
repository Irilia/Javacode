package twelve;

public class TestRepeatChar {
    public static char FindThreeRepeatChar(String value){
        if(value == null && value.length() == 0){
            throw new UnsupportedOperationException("there have null value");
        }
        //创建一个包含所有字符的数组，利用ASCII码
        int[] count = new int[255];
        //使用toCharArray将字符串转换为字符数组
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if((c>'A'&&c<'Z')||(c>'a'&&c<'z')){
                count[c]++;
            }
            if(count[c] == 3){
                return c;
            }
        }
        throw new UnsupportedOperationException("Don't have three number");
    }
    public static void main(String[] args) {
        System.out.println(FindThreeRepeatChar("Liuruijie is a lovely girl"));
    }
}
