package com.bittech.works;

public class CallNumber {
    public static void main(String[] args) {

        int value = callSurvivalNumber(1);
        System.out.println(value);
    }

    /*
        0 1 2 3 4 5 6 7 8 9
        1 2 3 4 5 6 7 8 9 10
    1   1 2 - 1 2 - 1 2 - 1
    2   2 -   1 2   - 1   2
    3   -     1 2     -   1
    4         2 -         1
    5         2           -
     */
    public static int callSurvivalNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must >0");
        }
        boolean[] status = new boolean[count];
        for (int i = 0; i < status.length; i++) {
            status[i] = true;
        }
        int index = -1;
        int counter = 0; //当前退出的人数 n-1
        int current = 0; //当前人报的数
        while (counter < status.length - 1) {
            //index 成环
            index = (index + 1) % status.length;//0
            if (!status[index]) {
                continue;
            }
            //报数
            current = (current + 1) % 3;   //1
            //退出
            if (current == 0) {
                counter++;
                status[index] = false;
            }
        }
        for (int i = 0; i < status.length; i++) {
            if (status[i]) {
                return i + 1;//1-n 0-(n-1)
            }
        }
        throw new RuntimeException("Not found");
    }
}
