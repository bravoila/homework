package com.techbow.homework.y2021.m09.cma;

public class LC160 {
    public class Solution {
        // 从两个头往后走，如果到头了，就从另一个node开始接着奏，查重
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA;
            ListNode pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
            // Note: In the case lists do not intersect, the pointers for A and B
            // will still line up in the 2nd iteration, just that here won't be
            // a common node down the list and both will reach their respective ends
            // at the same time. So pA will be NULL in that case.
        }
    }

    // hashSet
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode dummyA = headA;
            ListNode dummyB = headB;

            HashSet<ListNode> set = new HashSet<ListNode>();

            while(dummyA != null){
                set.add(dummyA);
                dummyA = dummyA.next;
            }

            while(dummyB != null){
                if(set.contains(dummyB)){
                    return dummyB;
                }
                dummyB = dummyB.next;
            }
            return null;
        }
    }
}
