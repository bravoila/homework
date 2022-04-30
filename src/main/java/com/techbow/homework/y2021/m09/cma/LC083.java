package com.techbow.homework.y2021.m09.cma;

public class LC083 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode cur = head.next;
            ListNode prev = head;

            while(cur != null){
                if(cur.val == prev.val){
                    prev.next = cur.next;
                    cur = cur.next;
                } else{
                    cur = cur.next;
                    prev = prev.next;
                }
            }
            return head;
        }
    }
}
