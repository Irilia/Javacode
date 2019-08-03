package com.irilia;

import com.irilia.cases.SortCase;

import java.util.Arrays;

public class TestDome {
    public static void main(String[] args) throws Exception {
        CaseLoader loader = new CaseLoader();
        loader.load().run();
       /*int[] a = {1,9,8,3,2,1,5,4,3,7,6,9,4,5,7,7,8,5};
       new SortCase().mergeSort(a);
        System.out.println(Arrays.toString(a));*/
    }
}
