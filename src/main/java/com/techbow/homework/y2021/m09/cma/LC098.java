package com.techbow.homework.y2021.m09.cma;

public class LC098 {
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
        public boolean isValidBST(TreeNode root) {
            return isBST(root, null, null);
        }
        public boolean isBST(TreeNode root, Integer lower, Integer upper){
            if(root == null) return true;

            if((upper != null && root.val >= upper) || (lower != null && root.val <= lower)) return false;

            return isBST(root.left, lower, root.val) && isBST(root.right, root.val, upper);
        }
    }

}
