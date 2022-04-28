package com.techbow.homework.y2021.m09.cma;

public class LC019 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;

            for(int i = 0; i <= n; i++){
                fast = fast.next;
            }

            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;

            return dummy.next;
        }
    }
}
