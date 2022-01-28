package com.techbow.homework.y2021.m09.cma;

public class LC1644 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        boolean pFound = false;
        boolean qFound = false;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode LCA = dfs(root, p, q);
            return pFound && qFound ? LCA : null;
        }

        public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return root;

            TreeNode left = dfs(root.left, p, q);
            TreeNode right = dfs(root.right, p, q);

            if (root == p) {
                pFound = true;
                return root;
            }
            if (root == q) {
                qFound = true;
                return root;
            }

//         两边都不是null 往上返自己
            if(left != null && right != null) return root;
//         如果有一个是null，返回那个不是null的
            return left == null ? right : left;
            // return left == null ? right : right == null ? left : root;
        }
    }
}
