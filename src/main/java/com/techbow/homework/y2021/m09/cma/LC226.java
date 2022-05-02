package com.techbow.homework.y2021.m09.cma;

public class LC226 {
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
//    先recursion后办事
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);
            root.left = right;
            root.right = left;
            return root;
        }
    }
//    先办事后recursion
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;

            TreeNode temp = root.left; // not recommanded
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

}
