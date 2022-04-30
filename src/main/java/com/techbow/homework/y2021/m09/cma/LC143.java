package com.techbow.homework.y2021.m09.cma;

public class LC143 {
    class Solution {
        public void reorderList(ListNode head) {
            if(head == null) return;
            // find middle
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null;
            ListNode curr = slow; // middle point
            ListNode tmp = null;

            // reverse the later half listnodes
            while(curr != null){
                tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // merge the two linkedlist
            ListNode first = head;
            ListNode second = prev;

            while(second.next != null){
                tmp = first.next;
                first.next = second;
                first = tmp;

                tmp = second.next;
                second.next = first;
                second = tmp;
            }
        }
    }
}
