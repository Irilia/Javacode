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
    public static void main5(String[] args) throws InterruptedException {
        DoubleLinkListImpl cHeadSingleList = new DoubleLinkListImpl();
        cHeadSingleList.addFirst(18);
        cHeadSingleList.addFirst(68);
        cHeadSingleList.addFirst(99);
        cHeadSingleList.display();//99 68 18
        //cHeadSingleList.addIndex(0,18);
        cHeadSingleList.display();//38 99 68 18
        //cHeadSingleList.addIndex(4,18);
        cHeadSingleList.display();//38 99 68 18 58
        //cHeadSingleList.addIndex(2,18);
        cHeadSingleList.display();//38 99 88 68 18 58
        //cHeadSingleList.removeAllKey(18);
        cHeadSingleList.display();
        cHeadSingleList.clear();
        Thread.sleep(1000);
        System.out.println("睡醒了");
        /*cHeadSingleList.remove(38);
        cHeadSingleList.display();
        cHeadSingleList.remove(68);
        cHeadSingleList.display();
        cHeadSingleList.remove(58);
        cHeadSingleList.display();
        System.out.println(cHeadSingleList.remove(188));*/
        //cHeadSingleList.display();

    }

    public static void main4(String[] args) throws InterruptedException {
        CHeadSingleListImpl cHeadSingleList = new CHeadSingleListImpl();

        cHeadSingleList.addFirst(18);
        cHeadSingleList.addFirst(18);
        cHeadSingleList.addFirst(99);
        cHeadSingleList.display();
        cHeadSingleList.addIndex(0,18);
        cHeadSingleList.addLast(100);
        cHeadSingleList.display();//99 88 78 18 100
        System.out.println(cHeadSingleList.contains(178));
        cHeadSingleList.removeAllKey(18);
        cHeadSingleList.display();
        cHeadSingleList.clear();
        Thread.sleep(1000);
        System.out.println("睡醒了");

    }


     //不带头节点的单链表测试用例
    public static void main(String[] args) throws InterruptedException {
        MySingleListImpl mySingleList = new MySingleListImpl();
        mySingleList.addFirst(18);
        mySingleList.addFirst(28);
        mySingleList.addFirst(99);
        mySingleList.display();//99 28 18
        mySingleList.addIndex(0,38);
        mySingleList.addLast(100);
        mySingleList.addLast(200);
        mySingleList.display();//38 99 28 18 100 200
        MySingleListImpl.Node cur = mySingleList.partition(38);
        mySingleList.show(cur);//

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
