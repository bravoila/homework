package com.techbow.homework.y2021.m09.cma;

public class LC894 {
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
        public List<TreeNode> allPossibleFBT(int n) {
            return dfs(n);
        }

        private List<TreeNode> dfs(int n){
            List<TreeNode> res = new ArrayList<>();
            if(n == 1){
                res.add(new TreeNode(0));
                return res;
            }
            for(int i = 1; i < n - 1; i++){
                List<TreeNode> left = dfs(i);
                List<TreeNode> right = dfs(n - i - 1);
                for(TreeNode l : left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}
