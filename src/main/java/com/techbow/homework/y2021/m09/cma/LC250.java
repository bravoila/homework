package com.techbow.homework.y2021.m09.cma;

public class LC250 {
    class Solution {
        private int count = 0;
        public int countUnivalSubtrees(TreeNode root) {
            dfs(root,0);
            return count;
        }

        private boolean dfs(TreeNode root, int target){
            if(root == null){
                return true;
            }
            boolean left = dfs(root.left, root.val);
            boolean right = dfs(root.right, root.val);
            if(left && right){
                count++;
                return target == root.val;
            }else{
                return false;
            }
        }
    }
}
