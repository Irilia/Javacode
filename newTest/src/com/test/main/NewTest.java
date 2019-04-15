package com.test.main;

public class NewTest {
    public static void main(String[] args) {
        class Solution {
            public ListNode reverseList(ListNode head) {
                ListNode prev = null;
                ListNode cur = head;
                ListNode reverseHead = null;
                while(cur != null){
                    ListNode curNext = cur.next;
                    if(curNext == null){
                        reverseHead = cur;
                    }
                    cur.next = prev;
                    prev = cur;
                    cur = curNext;
                }
                return reverseHead;
            }
        }
    }
}
