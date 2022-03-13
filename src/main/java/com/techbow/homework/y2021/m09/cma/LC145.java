package com.techbow.homework.y2021.m09.cma;

public class LC145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }
        private void dfs(TreeNode root, List<Integer> res){
            if(root == null){
                return;
            }
            dfs(root.left, res);
            dfs(root.right, res);
            res.add(root.val);

            return;
        }
    }
}

