package com.techbow.homework.y2021.m09.cma;

public class LC124 {
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
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }
        private int dfs(TreeNode root){
            if(root == null) return 0;

            int left = dfs(root.left);
            int right = dfs(root.right);

            left = Math.max(0, left);
            right = Math.max(0, right);

            max = Math.max(max, left + right + root.val);

            return Math.max(left + root.val, right + root.val);
        }
    }
}
