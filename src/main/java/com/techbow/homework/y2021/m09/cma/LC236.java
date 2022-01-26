package com.techbow.homework.y2021.m09.cma;

public class LC236 {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         如果题目说不保证p,q一定在tree里，那要先preprocessing查是否都在tree里，再做下面的。
//         找不到p,q 一找到底，遇到null，返null
            if(root == null) return null;
//         找到了p,q下面就不看了，直接往上返root
            if(root == p || root == q) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
//         两边都不是null 往上返自己
            if(left != null && right != null) return root;
//         如果有一个是null，返回那个不是null的
            return left == null ? right : left;
        }
    }
}
