package com.techbow.homework.y2021.m09.cma;

public class LC061 {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null){
                return null;
            }

            int count = 0;
            int len = 1;
            ListNode curr = head;

            while(curr.next != null){
                curr = curr.next;
                len ++;
            }
            curr.next = head;
            // 向右rotate k等于向左len - k % len
            while(count < len - k % len ){
                curr = curr.next;
                count++;
            }

            ListNode tmp = curr.next;
            curr.next = null;

            return tmp;
        }
    }
}
