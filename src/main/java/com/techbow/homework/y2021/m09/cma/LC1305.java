package com.techbow.homework.y2021.m09.cma;

public class LC1305 {
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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> result = new ArrayList<>();
            dfs(root1, result);
            dfs(root2, result);
            Collections.sort(result);
            return result;

        }

        private void dfs(TreeNode root, List<Integer> res){
            if(root == null) return;

            dfs(root.left, res);
            int temp = root.val;
            res.add(temp);
            dfs(root.right, res);

            return;
        }
    }
}
