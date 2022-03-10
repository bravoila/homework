package com.techbow.homework.y2021.m09.cma;

public class LC099 {
    class Solution {
        private TreeNode prev = null;

        private void dfs(TreeNode root, TreeNode[] error){
            if(root == null){
                return;
            }
            dfs(root.left, error);
            if(prev != null && prev.val > root.val){
                error[1] = root;
                if(error[0] == null){
                    error[0] = prev;
                }
            }
            prev = root;
            dfs(root.right, error);
        }

        public void recoverTree(TreeNode root) {
            TreeNode[] error = new TreeNode[2];
            error[0] = null;
            error[1] = null;

            dfs(root, error);

            if(error[0] != null && error[1] != null){
                int temp = error[0].val;
                error[0].val = error[1].val;
                error[1].val = temp;
            }
        }
    }
}
