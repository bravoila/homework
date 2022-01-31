package com.techbow.homework.y2021.m09.cma;

public class LC109 {
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
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
     * right; TreeNode(int x) { val = x; } }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head==null) return null;
            return toBST(head,null);
        }
        public TreeNode toBST(ListNode head, ListNode tail){
            ListNode slow = head;
            ListNode fast = head;
            if(head==tail) return null;

            while(fast!=tail&&fast.next!=tail){
                fast = fast.next.next;
                slow = slow.next;
            }
            //fast走两步，slow走一步，fast走到头,slow就是中间的

            TreeNode thead = new TreeNode(slow.val);
            thead.left = toBST(head,slow);
            thead.right = toBST(slow.next,tail);
            return thead;
        }
    }


    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> nums = new ArrayList<>();
            while(head != null){
                nums.add(head.val);
                head = head.next;
            }
            return helper(nums, 0, nums.size() - 1);
        }

        private TreeNode helper(List<Integer> nums, int start, int end){
            if(start > end) return null;

            int med = start + (end - start)/2;
            TreeNode root = new TreeNode(nums.get(med));
            root.left = helper(nums, start, med - 1);
            root.right = helper(nums, med + 1, end);
            return root;

        }
    }


}
