package com.techbow.homework.y2021.m09.cma;

public class LC1721 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            int len = 0;
            ListNode root = head;
            ListNode first = null;

            while(root != null){
                len++;
                if(len == k){
                    first = root;
                }
                root = root.next;
            }

            ListNode second = head;
            while(len > k){
                len--;
                second = second.next;
            }

            int temp = first.val;
            first.val = second.val;
            second.val = temp;

            return head;
        }
    }
}
