package com.techbow.homework.y2021.m09.cma;

public class LC111 {
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
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            // 双边都是nul，走的是base case
            // 下面是单边null的情况
            if(leftHeight == 0){
                return rightHeight + 1;
            }
            if(rightHeight == 0){
                return leftHeight + 1;
            }
            return Math.min(leftHeight, rightHeight) + 1;
        }
    }
}
