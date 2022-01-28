package com.techbow.homework.y2021.m09.cma;

public class LC112 {
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return pathSum(root, targetSum, 0);
        }

        private boolean pathSum(TreeNode root, int targetSum, int curSum){
            if(root == null) return false;

            if(root.left == null && root.right == null) {
                return targetSum == curSum + root.val;
            }
            boolean boolean1 = false;
            boolean boolean2 = false;

            if(root.left != null){
                boolean1 = pathSum(root.left, targetSum, curSum + root.val);
            }

            if(root.right != null){
                boolean2 = pathSum(root.right, targetSum, curSum + root.val);
            }

            return boolean1 || boolean2;
        }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return checkPath(root, sum, 0);
        }

        private boolean checkPath(TreeNode root, int sum, int curSum) {
            if(root == null) return false;
            if(root.left == null && root.right == null) {
                return sum == curSum + root.val;
            }
            return checkPath(root.left, sum, curSum + root.val) ||
                    checkPath(root.right, sum, curSum + root.val);
        }
    }
}
