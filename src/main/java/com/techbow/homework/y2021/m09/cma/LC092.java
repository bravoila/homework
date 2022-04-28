package com.techbow.homework.y2021.m09.cma;

public class LC092 {
    class Solution {
        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseN(head, right);
            }
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;

        }

        private ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
}
