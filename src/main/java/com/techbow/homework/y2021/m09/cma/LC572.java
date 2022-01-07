package com.techbow.homework.y2021.m09.cma;

public class LC572 {
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            /** at each node, check if tree are the same
             */
            if(root == null){
                if(subRoot == null){
                    return true;
                }else{
                    return false;
                }
            }

            boolean isRootSame = isSameTree(root, subRoot);
            boolean isLeftSame = isSubtree(root.left, subRoot);
            boolean isRightSame = isSubtree(root.right, subRoot);

            return isRootSame || isLeftSame || isRightSame;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if(p== null || q == null) return false;
            if(p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
