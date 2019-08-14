package com.bittech.works;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(2));
    }

    public static boolean isHappyNumber(int num) {
        if (num <= 0) {
            return false;
        }
        //1000
        Set<Integer> numbers = new HashSet<>();
        int n = num;
        while (n != 1) {
            int sum = 0;
            char[] chars = String.valueOf(n).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int bitDig = Integer.parseInt(new String(chars, i, 1));
                sum += (bitDig * bitDig);
            }
            n = sum;
            if (numbers.contains(n)) {
                return false;
            } else {
                numbers.add(n);
            }
        }
        return true;
    }

    public static boolean isHappyNumber2(int num) {
        if (num <= 0) {
            return false;
        }
        //1000
        int counter = 0;
        int n = num;
        while (n != 1) {
            int sum = 0;
            char[] chars = String.valueOf(n).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int bitDig = Integer.parseInt(new String(chars, i, 1));
                sum += (bitDig * bitDig);
            }
            n = sum;
            counter++;
            if (counter > 1000) {
                return false;
            }
        }
        return true;
    }
}
