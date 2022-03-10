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

    class Solution {
        private TreeNode prev = null;

        public boolean isValidBST(TreeNode root) {
            return val(root);
        }

        private boolean val(TreeNode root){
            if(root == null){
                return true;
            }
            // 一杆子到左底，相当于把tree拉直了，检查i和i-1值的大小
            if(!val(root.left)){
                return false;
            }
            if(prev != null && prev.val > root.val){
                return false;
            }
            prev = root;
            return val(root.right);
        }
    }
}
