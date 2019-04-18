package com.bit.main;

import com.bit.dao.CHeadSingleListImpl;
import com.bit.dao.DoubleLinkListImpl;
import com.bit.dao.MySingleListImpl;
import com.bit.dao.SequenceImpl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-03-31
 * Time: 15:41
 */
public class TestMain {
    //创建两个相交的单链表
    public static void createCut(MySingleListImpl.Node headA,
                                 MySingleListImpl.Node headB) {

        headA.next = headB.next.next;
    }

    //参数为对应单链表的头结点
    public static MySingleListImpl.Node getIntersectionNode
            (MySingleListImpl.Node headA,
             MySingleListImpl.Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int headALength = 0;
        int headBLength = 0;
        //pL 永远指向最长的单链表
        MySingleListImpl.Node pL = headA;
        //pS 永远指向最短的单链表
        MySingleListImpl.Node pS = headB;

        while(pL != null) {
            headALength++;
            pL = pL.getNext();
        }

        while(pS != null) {
            headBLength++;
            pS = pS.getNext();
        }
        // pL == pS ==null;
        pL = headA;
        pS = headB;
        //1、确定哪个单链表是长的单链表
        int myLen = headALength-headBLength;

        if(myLen < 0) {
            pL = headB;
            pS = headA;
            myLen = headBLength-headALength;
        }
        //2、让长的单链表走长度的差值
        for (int i = 0; i < myLen; i++) {
            pL = pL.getNext();
        }
        //3、一人一步走
        while(pL != null && pS != null && pL != pS) {
            pL = pL.getNext();
            pS = pS.getNext();
        }
        if(pL != null && pS != null && pL == pS ) {
            return pL;
        }
        return null;
    }

    //合并两个有序的单链表
    public static MySingleListImpl.Node mergeTwoLists
    (MySingleListImpl.Node headA,
     MySingleListImpl.Node headB) {

        MySingleListImpl mySingleList = new
                MySingleListImpl();

        MySingleListImpl.Node node =
                mySingleList.new Node(-1);

        MySingleListImpl.Node tmpNode = node;

        while(headA != null && headB != null) {
            if(headA.getData() > headB.getData()) {
                tmpNode.next = headB;
                headB = headB.next;
                tmpNode = tmpNode.next;
            }else {
                tmpNode.next = headA;
                headA = headA.next;
                tmpNode = tmpNode.next;
            }
        }
        if(headA != null) {
            tmpNode.next = headA;
        }

        if(headB != null) {
            tmpNode.next = headB;
        }
        return node.next;
    }

     //不带头节点的单链表测试用例
    public static void main(String[] args) throws InterruptedException {
        MySingleListImpl mySingleList = new MySingleListImpl();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(13);
       // mySingleList.display();//99 28 18
        //mySingleList.addIndex(0,38);
        mySingleList.addLast(14);
        //mySingleList.addLast(12);
        mySingleList.addLast(15);
        mySingleList.display();//38 99 28 18 100 200

        MySingleListImpl mySingleList2 =
                new MySingleListImpl();
        mySingleList2.addLast(9);
        mySingleList2.addLast(10);
        mySingleList2.addLast(11);
        mySingleList2.addLast(22);
        mySingleList2.addLast(33);
        mySingleList2.addLast(44);
        mySingleList2.display();
        System.out.println("===============");
        MySingleListImpl.Node cur =
             mergeTwoLists(mySingleList.getHead(),
                mySingleList2.getHead());

        mySingleList.show(cur);


       /* createCut(mySingleList.getHead(),
                mySingleList2.getHead());
        System.out.println("=================");
        mySingleList.display();
        mySingleList2.display();
        System.out.println("=================");
        MySingleListImpl.Node cur =
                getIntersectionNode
                        (mySingleList.getHead(),
                mySingleList2.getHead());

        System.out.println(cur.getData());*/





       /* mySingleList.createCycle();
        System.out.println(mySingleList.hasCycle());
        MySingleListImpl.Node cur =
                       mySingleList.detectCycle();
        System.out.println(cur.getData());
*/
        //System.out.println(mySingleList.chkPalindrome());
        //mySingleList.reverseList();
        //mySingleList.show(mySingleList.reverseList());
        //mySingleList.show(mySingleList.deleteDuplication());
        /*MySingleListImpl.Node cur = mySingleList.partition(97);
        mySingleList.show(cur);//
*/
        /*MySingleListImpl.Node cur =
                mySingleList.findKthToTail(6);
        System.out.println(cur.getData());*/


        /*MySingleListImpl.Node cur = mySingleList.middleNode();
        System.out.println(cur.getData());*/

       /* System.out.println(mySingleList.contains(178));
        mySingleList.removeAllKey(18);
        mySingleList.display();
        mySingleList.clear();
        Thread.sleep(1000);
        System.out.println("睡醒了");*/
        /*mySingleList.remove(99);
        mySingleList.display();
        mySingleList.remove(78);
        mySingleList.display();
        mySingleList.remove(100);
        mySingleList.display();*/
    }

   //顺序表测试用例
    public static void main2(String[] args) {
        SequenceImpl sequence = new SequenceImpl();
        for (int i = 0; i < 10; i++) {
            sequence.add(i,i);
        }
        sequence.display();
        sequence.add(10,"bit");
        sequence.display();

        sequence.add(11,"java");
        sequence.display();

        sequence.remove("bit");
        sequence.display();
        System.out.println("================");
        sequence.clear();
        sequence.display();
        for (int i = 0; i < 10; i++) {
            sequence.add(i,i);
        }
        sequence.display();
    }
}
