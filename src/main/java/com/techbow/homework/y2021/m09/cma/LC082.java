package com.techbow.homework.y2021.m09.cma;

public class LC082 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode newhead = new ListNode(0,head);
            ListNode pred = newhead;

            while(head != null){
                if(head.next != null && head.val == head.next.val){
                    while(head.next !=null && head.val == head.next.val){
                        head = head.next;
                    }
                    pred.next = head.next;
                } else{
                    pred = pred.next;
                }
                head = head.next;
            }
            return newhead.next;
        }
    }
}
