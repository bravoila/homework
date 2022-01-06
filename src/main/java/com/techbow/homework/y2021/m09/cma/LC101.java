package com.techbow.homework.y2021.m09.cma;

public class LC101 {
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
        public boolean isSymmetric(TreeNode root) {
            return root == null ? true : isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode leftNode, TreeNode rightNode){
            if(leftNode == null && rightNode == null) return true;
            if(leftNode == null || rightNode == null) return false;
            if(leftNode.val != rightNode.val) return false;
            return isMirror(leftNode.left, rightNode.right) && isMirror(rightNode.left, leftNode.right);
        }
    }
}
