package com.techbow.homework.y2021.m09.cma;

public class LC086 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummyLess = new ListNode(0);
            ListNode dummyGreat = new ListNode(0);
            ListNode lessHead = dummyLess;
            ListNode greatHead = dummyGreat;
            ListNode cur = head;

            while(cur != null){
                if(cur.val < x){
                    dummyLess.next = cur;
                    dummyLess = dummyLess.next;
                } else{
                    dummyGreat.next = cur;
                    dummyGreat = dummyGreat.next;
                }
                cur = cur.next;
            }
            dummyGreat.next = null;
            dummyLess.next = greatHead.next;
            return lessHead.next;
        }
    }
}
