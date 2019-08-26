package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestDemoTree {
    int val;
    TestDemoTree root;
    TestDemoTree left;
    TestDemoTree right;
    public static List<Integer> preorderReturn(TestDemoTree root){
        List<Integer> list = new ArrayList<>();
        process(list,root);
        return list;
    }
    private static  void process (List<Integer> list,TestDemoTree root){

    }
}
