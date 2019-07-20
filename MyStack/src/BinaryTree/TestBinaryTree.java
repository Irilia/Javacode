package BinaryTree;

public class TestBinaryTree<E extends Comparable<E>> implements BinTree<E> {
    private class Node {
        E data;
        Node left;
        Node right;
        public Node(E data) {
            this.data = data;
        }
    }
    //根节点
    private Node root;
    //节点个数
    private int size;
    @Override
    public void add(E e) {
        if(root==null){
            Node node = new Node(e);
            root = node;
            size++;
        }
        //递归查找插入位置
        add(root,e);
    }
    //以指定的node为根节点插入指定元素e
    private void add(Node node,E e){
        //插入的值刚好是当前树根节点的值
        if(node.data.compareTo(e)==0) {
            return;
        }else if(e.compareTo(node.data)<0&&node.left==null){
            //找到插入位置，在左子树插入
            Node node1 = new Node(e);
            node.left = node1;
            size++;
        }else if(e.compareTo(node.data)>0&&node.right==null){
            //找到插入位置，在右子树插入
            Node node1 = new Node(e);
            node.right = node1;
            size++;
        } else if(e.compareTo(node.data)<0){
            //递归找左侧节点
            add(node.left,e);
        }else if(e.compareTo(node.data)>0){
            //递归找右侧节点
            add(node.right,e);
        }
    }

    @Override
    public boolean contains(E e) {
        if(root==null){
            return false;
        }
        //以根节点开始递归的查找元素
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(node.data.equals(e) ){
            return true;
        }else if(e.compareTo(node.data)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public E getMax() {
        return null;
    }

    @Override
    public E removeMin() {
        return null;
    }

    @Override
    public E removeMax() {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
