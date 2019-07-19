package BinaryTree;

public interface BinTree<E> {
    void add(E e);
    boolean contains(E e);

    void preOrder();//前序遍历
    void inOrder();//中序遍历
    void postOrder();//后序遍历

    E getMin();//取得最小值
    E getMax();//取得最大值
    E removeMin();//删除最小值
    E removeMax();//删除最大值
    boolean remove(E e);//删除任意值
    int size();//二叉树下有几个节点

}
