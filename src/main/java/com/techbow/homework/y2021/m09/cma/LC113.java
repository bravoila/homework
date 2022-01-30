package com.techbow.homework.y2021.m09.cma;

public class LC113 {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, targetSum, 0, path, res);
            return res;
        }

        private void dfs(TreeNode root, int targetSum, int curSum, List<Integer> path, List<List<Integer>> res){
            if(root == null) return;

            curSum += root.val;
            path.add(root.val);

            if ((curSum == targetSum) && (root.left == null) && (root.right == null)){
                res.add(new ArrayList<>(path));
                // return;
            } else{
                dfs(root.left, targetSum, curSum, path, res);
                dfs(root.right, targetSum, curSum, path, res);
            }

            path.remove(path.size() - 1);

            return;
        }
    }


    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, targetSum, 0, path, res);
            return res;
        }

        private void dfs(TreeNode root, int targetSum, int curSum, List<Integer> path, List<List<Integer>> res){
            if(root == null) return;

            curSum += root.val;
            path.add(root.val);

            if ((curSum == targetSum) && (root.left == null) && (root.right == null)){
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }

            dfs(root.left, targetSum, curSum, path, res);
            dfs(root.right, targetSum, curSum, path, res);

            path.remove(path.size() - 1);

            return;
        }
    }
}
