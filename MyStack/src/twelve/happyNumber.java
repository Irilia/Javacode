package twelve;

public class happyNumber {
    public static boolean isHappyNumber (int num) {
        if(num<0) {
            return false;
        }
        //取到每一位的方法：
        //1.取模
        //2.int->String->char[]->char->String->int
        int counter = 0;
        int n = num;
        while(n != 1) {
            int sum = 0;
            char[] chars = String.valueOf(num).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int bigDig =Integer.parseInt(new String(chars,i,1));
                sum += (bigDig*bigDig);
            }
            n=sum;
            counter++;
            if(counter>1000){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
    }
}
