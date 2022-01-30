package com.techbow.homework.y2021.m09.cma;

public class LC437 {
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
        int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if(root == null) return 0;

            dfs(root, targetSum, 0);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return count;
        }

        private void dfs(TreeNode root, int targetSum, int curSum){
            if(root == null) return;

            curSum += root.val;
            if(curSum == targetSum){
                count ++;
            }

            dfs(root.left, targetSum, curSum);
            dfs(root.right, targetSum, curSum);

        }
    }


}
