package com.techbow.homework.y2021.m09.cma;

public class LC025 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            //cc
            ListNode curr = head;
            int count = 0;
            while (curr != null && count != k) {
                // find the k+1 node, count < k is the base case
                curr = curr.next;
                count++;
            }
            // if > k node is found
            if (count == k) {
                curr = reverseKGroup(curr, k); // 2 reverse list with k+1 node as head
                // head - head-pointer to direct part,
                // curr - head-pointer to reversed part;
                while (count-- > 0) { // reverse current k-group:
                    // reverse by 1
                    ListNode tmp = head.next; // tmp - next head in direct part
                    head.next = curr; // preappending "direct" head to the reversed list
                    curr = head; // move head of reversed part to a new node
                    head = tmp; // move "direct" head to the next node in direct part
                }
                head = curr;
            }
            return head;
        }
    }
}
