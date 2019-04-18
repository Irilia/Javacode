package com.bit.dao;

import com.bit.Impl.ILinked;

import javax.xml.soap.Node;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-03-31
 * Time: 16:19
 */
public class MySingleListImpl implements ILinked {

    public class Node {
        private int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
    private Node head;

    public MySingleListImpl() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        //第一次插入数据
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //第一次插入
        if(cur == null) {
            this.head = node;
        }else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //找到index-1位置的节点
    private Node searchIndex(int index) {
        checkIndex(index);
        //0
        if(index == 0) {
            return null;
        }
        int count = 0;//记录走的步数
        Node cur = this.head;
        while(cur.next != null && count < index-1) {
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
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if(cur == null) {
            node.next = this.head;
            this.head = node;
        }else{
            node.next = cur.next;
            cur.next = node;
        }
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
    //null
    private Node searchPre(int key) {
        //1、是不是第一个节点 if(head.data == key)
        Node pre = this.head;
        if(pre.data == key) {
            return this.head;
        }
        //2、if(cur.next.data == key)
        while(pre.next != null){
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        //if(head.data == key)
        int oldData = 0;
        Node pre = searchPre(key);
        if(pre == null) {
            //return -1;
            throw new UnsupportedOperationException("没有key的前驱");
        }
        if(pre == this.head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    @Override
    public int getLength() {
        //节点的个数
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }

    public Node middleNode() {
        Node cur = this.head;
        int len = getLength()/2;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }


    public Node findKthToTail(int k) {
        //k = -1  k > g
        Node fast = this.head;
        Node slow = this.head;
        if(fast == null || k <= 0 || k > getLength()) {
            return null;
        }
        //fast先走K-1步
        while(k-1 > 0) {
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while(pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.data < x) {
                if(beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = pHead;
                    beforeEnd = beforeEnd.next;
                }
            }else{
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = pHead;
                    afterEnd = afterEnd.next;
                }
            }
            pHead = pHeadNext;
        }
        //第一段没有数据的时候(单链表的所有数据都比x大)
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //单链表的逆置(头插法进行逆置)
    public Node reverseList() {
        Node reverseHead = null;
        Node prev = null;
        Node cur = this.head;
        while(cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }

    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node tmpHead = newHead;
        Node cur = this.head;
        while(cur != null) {
            if(cur.next != null && cur.data ==
                    cur.next.data) {
                while(cur.next != null&&
                        cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                newHead.next = cur;
            }else{
                newHead.next = cur;
                newHead = cur;
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }

    public boolean chkPalindrome() {
        if(this.head == null) {
            return false;
        }else if(this.head.next == null) {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next!=null) {
            //fast.next != null && fast.next.next
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node p1 = p.next;
        while(p != null) {
            p.next = slow;
            slow = p;
            p = p1;
            if(p1 != null) {
                p1 = p1.next;
            }
        }
        while(slow != this.head) {
            if(slow.data != this.head.data) {
                return false;
            }
            //偶数节点
            if(this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }
    //创建一个环
    public void createCycle() {
        Node cur =  this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next;
    }
    //是否有环  走两步   走一步
    //问题：快的引用走三步 和 走两步 区别？
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //每一次发生变化，这里都需要进行判断
            if(fast == slow) {
                break;
            }
        }
        if(fast!=null && slow!=null && fast == slow) {
            return true;
        }
        return false;
    }

    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //每一次发生变化，这里都需要进行判断
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void show(Node newHead) {
        Node cur = newHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
