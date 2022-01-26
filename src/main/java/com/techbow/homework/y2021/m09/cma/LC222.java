package com.techbow.homework.y2021.m09.cma;

public class LC222 {
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
    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            int countLeft = countNodes(root.left);
            int countRight = countNodes(root.right);

            return countLeft + countRight + 1;
        }
    }

//    O(1) 解法

}
