package com.techbow.homework.y2021.m09.cma;

public class LC095 {
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
        public List<TreeNode> generateTrees(int n) {
            return dfs(1,n);
        }

        private List<TreeNode>dfs(int start, int end){
            List<TreeNode> res = new ArrayList<>();

            if(start > end){
                res.add(null);
                return res;
            }

            for(int k = start; k <= end; k ++){
                List<TreeNode> left = dfs(start, k - 1);
                List<TreeNode> right = dfs(k + 1, end);
                for(TreeNode l : left){
                    for(TreeNode r: right){
                        TreeNode root = new TreeNode(k);
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
