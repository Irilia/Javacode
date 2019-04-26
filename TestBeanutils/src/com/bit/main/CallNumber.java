package com.bit.main;

public class CallNumber {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(callSurvivalNumber(10));
    }
    public static int callSurvivalNumber(int count) throws IllegalAccessException {
        if(count<= 0){
            throw new IllegalAccessException("count must bigger than 0;");
        }
        boolean[] status = new boolean[count];
        for (int i = 0; i < status.length; i++) {
            status[i] = true;
        }
        //下标
        int index = -1;
        //退出人数
        int counter = 0;
        //当前人报数
        int number = 0;
        while(counter < status.length-1){
            //index成环，用取模获得环
            index = (index +1) % status.length;
            if(!status[index]){
                continue;
            }
            number = (number + 1)%3;

            if(number == 0){
                status[index] = false;
                counter++;
            }
        }
        for (int i = 0; i < status.length; i++) {
            if(status[i]){
                return i+1;
            }
        }
        return -1;
    }
}
