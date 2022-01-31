package com.techbow.homework.y2021.m09.cma;

public class LC114 {
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
        TreeNode prev;
        public void flatten(TreeNode root) {
            if(root == null) return;
            dfs(root);
            return;
        }

        private void dfs(TreeNode root){
            if(root == null) return;
            TreeNode right = root.right;

            if(prev != null){
                prev.left = null;
                prev.right = root;
            }

            prev = root;

            dfs(root.left);
            dfs(right);
            return;
        }
    }

}
