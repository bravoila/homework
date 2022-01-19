package com.techbow.homework.y2021.m09.cma;

public class LC142 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> visited = new HashSet<ListNode>();

            ListNode node = head;

            while(node != null){
                if(visited.contains(node)){
                    return node;
                }
                visited.add(node);
                node = node.next;
            }
            return null;
        }
    }
}
