package com.techbow.homework.y2021.m09.cma;

public class LC235 {
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
            int maxVal = Math.max(p.val, q.val);
            int minVal = Math.min(p.val, q.val);
            while(root.val < minVal || root.val > maxVal){
                if(root.val > maxVal){
                    root = root.left;
                } else if(root.val < minVal){
                    root = root.right;
                }
            }
            return root;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int maxVal = Math.max(p.val, q.val);
            int minVal = Math.min(p.val, q.val);
            if(root.val > maxVal){
                return lowestCommonAncestor(root.left, p, q);
            } else if(root.val < minVal){
                return lowestCommonAncestor(root.right, p, q);
            } else{
                return root;
            }
        }
    }

}
