package com.techbow.homework.y2021.m09.cma;

public class LC530 {
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
        public int getMinimumDifference(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);

            int min=Integer.MAX_VALUE;
            for(int i=0; i<res.size()-1;i++)
                min= Math.min(min, res.get(i+1) - res.get(i));
            return min;
        }

        private void dfs(TreeNode node, List<Integer> res){
            if(node == null) return;

            dfs(node.left, res);
//         因为是BST，左支越往下越小，所以返值上来在这加value起到了从小到大排序的作用
            int temp = node.val;
            res.add(temp);
            dfs(node.right, res);

            return;

        }
    }
}
