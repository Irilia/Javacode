package BinaryTree;

public class Bin_Tree {
    public static void main(String[] args) {
        BinTree<Integer> binTree = new TestBinaryTree<>();
        int[] num = new int[]{5,1,8,3,4,7,9};
        for (int i = 0; i < num.length; i++) {
            binTree.add(num[i]);
        }
        System.out.println(binTree.contains(7));
        System.out.println(binTree.contains(10));
    }
}
