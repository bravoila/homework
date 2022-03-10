package com.techbow.homework.y2021.m09.cma;

public class LC002 {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum;
            int val1;
            int val2;
            int carryon = 0;

            ListNode head = new ListNode(0);
            ListNode res = new ListNode(0);
            res = head;

            while(l1 != null || l2 != null){
                if(l1 != null){
                    val1 = l1.val;
                } else{
                    val1 = 0;
                }

                if(l2 != null){
                    val2 = l2.val;
                } else{
                    val2 = 0;
                }

                sum = val1 + val2 + carryon;
                carryon = sum /10;

                ListNode nxt = new ListNode(sum %10);
                res.next = nxt;
                res = nxt;

                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }

            if(carryon > 0){
                res.next = new ListNode(carryon);
            }
            return head.next;
        }
    }
}
