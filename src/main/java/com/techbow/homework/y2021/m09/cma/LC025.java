package com.techbow.homework.y2021.m09.cma;

public class LC025 {/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
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
                // System.out.println("--");
                // System.out.println(curr.val);
                // head - head-pointer to direct part,
                // curr - head-pointer to reversed part;
                while (count-- > 0) { // reverse current k-group:
                    // reverse by 1
                    ListNode next = head.next; // next用来存head，正序的linkedlist
                    head.next = curr; // 把正向的list的头结点反向指向已经反转的linkedlist
                    curr = head; // 相当于prev++， 把curr往后挪 move head of reversed part to a new node
                    head = next; // 相当于cur++， 把head往后挪  move "direct" head to the next node in direct part
                }
                head = curr;
            }
            return head;
        }
    }
}
