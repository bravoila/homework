package com.techbow.homework.y2021.m09.cma;

public class LC1676 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
// 与LC236思路几乎一样，只是base case不一样
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            for(TreeNode node: nodes){
                if (root == null || root == node) {
                    return root;
                }
            }

            TreeNode left = lowestCommonAncestor(root.left, nodes);
            TreeNode right = lowestCommonAncestor(root.right, nodes);

            if (left != null && right != null) {
                return root;
            } else if(left == null){

            }
            return left == null ? right : left;
        }
    }


}
