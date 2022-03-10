package com.techbow.homework.y2021.m09.cma;

public class LC298 {
    class Solution {
        private int maxLen = 0;
        public int longestConsecutive(TreeNode root) {
            dfs(root);
            return maxLen;
        }

        private int dfs(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);

            int localLen = 1;
            if(root.left != null && root.left.val == root.val + 1){
                localLen = 1 + left;
            }
            if(root.right != null  && root.right.val == root.val + 1){
                localLen = Math.max(localLen, 1 + right);
            }
            maxLen = Math.max(maxLen, localLen);
            return localLen;
        }
    }
}
