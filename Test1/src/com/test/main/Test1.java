package com.test.main;

import com.test.code.MyLinkedImpl;

public class Test1 {
    public static void main(String[] args) {
        MyLinkedImpl myLinked = new MyLinkedImpl();
        for (int i = 0; i < 10; i++) {
            myLinked.add(i,i);
        }
        myLinked.display();
        myLinked.add(11,11);
        myLinked.display();
        myLinked.add(13,99);
        System.out.println("===========");
        myLinked.display();



    }
}
