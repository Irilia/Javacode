package daydata;

import java.util.Arrays;
import java.util.Scanner;

public class GeneTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        float[] floats = new float[str.length()-n+1];
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int count = 0;
            for (int j = i; j < j+5; j++) {
                if(ch[j] == 'G'||ch[j] == 'C'){
                    count++;
                }
            }
            if(!(i>floats.length-1)){
                floats[i] = count;
            }
        }



        /*float tmp = floats[0];
        int last = floats.length-1;
        int first = 0;
        while(first<last){
            while(first<last){
                if(floats[last]<tmp){
                    floats[first] = floats[last];
                    last--;
                }
            while(first<last){
                if(floats[first] > floats[last]) {
                    floats[last] = floats[first];
                    first++;
                }
            }

        }*/

    }
}
