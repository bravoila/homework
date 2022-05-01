package com.techbow.homework.y2021.m09.cma;

public class LC369 {
//    反转list两次的做法
    class Solution {
        public ListNode plusOne(ListNode head) {
            if(head == null){
                return head;
            }

            ListNode rv = reverse(head);
            int carry = 1;
            ListNode cur = rv;

            while(cur != null){
                int val = cur.val + 1;
                if(val > 9){
                    cur.val = val % 10;
                    cur = cur.next;
                } else{
                    cur.val = val;
                    break;
                }
            }

            if(cur == null){
                head.next = new ListNode(1);
            }

            return reverse(rv);

        }

        private ListNode reverse(ListNode head){
            ListNode rvhead = null;
            ListNode cur = head;
            ListNode next =null;

            while(cur != null){
                next = cur.next;
                cur.next = rvhead;
                rvhead = cur;
                cur = next;
            }
            return rvhead;
        }
    }

    // 不反转
    class Solution {
        public ListNode plusOne(ListNode head) {
            // sentinel head
            ListNode sentinel = new ListNode(0);
            sentinel.next = head;
            ListNode notNine = sentinel;

            // find the rightmost not-nine digit
            while (head != null) {
                if (head.val != 9) {
                    notNine = head;
                }
                head = head.next;
            }

            // increase this rightmost not-nine digit by 1
            notNine.val++;
            notNine = notNine.next;

            // set all the following nines to zeros
            while (notNine != null) {
                notNine.val = 0;
                notNine = notNine.next;
            }

            return sentinel.val != 0 ? sentinel : sentinel.next;
        }
    }
}
