package com.bit.dao;

import com.bit.Impl.IDoubleLinked;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-04-07
 * Time: 12:03
 */
public class DoubleLinkListImpl implements IDoubleLinked {

    class Node {
        private int data;//数据
        private Node prev;//前驱
        private Node next;//后继

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node last;//标志尾巴
    public DoubleLinkListImpl() {
        this.head = null;
        this.last = null;
    }
    @Override
    public void addFirst(int data) {
        //第一次插入
        Node node = new Node(data);
        if(head == null) {
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            node.next.prev = node;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        int count = 0;
        while(count < index){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return true;
        }
        if(index == getLength()) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key){
                int oldData = cur.data;
                //删除的节点是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else{
                        //删除最后一个节点，last需要指回来。
                        this.last = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key){
                //删除的节点是头结点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else{
                        //删除最后一个节点，last需要指回来。
                        this.last = cur.prev;
                    }
                }
                //return oldData;
            }
            cur = cur.next;
        }
        //return -1;
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        Node cur = null;
        while(this.head != null){
            cur = this.head.next;
            head.next = null;
            head.prev = null;
            head = cur;
        }
        this.last = null;
    }
}
