package com.techbow.homework.y2021.m09.cma;

public class LC129 {
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
        int res = 0;
        public int sumNumbers(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int curNum){
            if(root == null) return;
            curNum = curNum *10 + root.val;
            if(root.left == null && root.right == null){
                res += curNum;
            }

            dfs(root.left, curNum);
            dfs(root.right, curNum);
        }
    }
}
