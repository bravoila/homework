public class LC206 {
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
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode curr = head;

            while(curr != null){
                ListNode temp = curr.next;
                curr.next = dummy.next;
                dummy.next = curr;
                curr = temp;

            }
            return dummy.next;
        }
    }


//    recursion
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode newHead = reverseList(head.next);
//wall
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
