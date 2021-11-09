public class LC024 {
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) { // 1
                return head;
            }
            ListNode subHead = swapPairs(head.next.next); // 2
            head.next.next = head; // 3
            ListNode newHead = head.next; // 4
            head.next = subHead; // 5
            return newHead;
        }
    }

}
