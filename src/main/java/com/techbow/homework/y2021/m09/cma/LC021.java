package com.techbow.homework.y2021.m09.cma;

public class LC021 {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            else if (l2 == null) {
                return l1;
            }
            else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }


    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null ) return list2;
            if (list2 == null ) return list1;

            ListNode head, cur;
            if (list1.val < list2.val){
                head = list1;
                list1 = list1.next;
            } else{
                head = list2;
                list2 = list2.next;
            }
            cur = head;
            while ( list1 != null && list2 != null ){
                if ( list1.val < list2.val ){
                    cur.next = list1;
                    list1 = list1.next;
                }else{
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            if ( list1 != null ) cur.next = list1;
            if ( list2 != null ) cur.next = list2;

            return head;
        }
    }


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // maintain an unchanging reference to node ahead of the return node.
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // At least one of l1 and l2 can still have nodes at this point, so connect
            // the non-null list to the end of the merged list.
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }
    }
}
