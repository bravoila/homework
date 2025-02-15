package com.techbow.homework.y2021.m09.cma;

public class LC094 {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;

        }
        private void dfs(TreeNode root, List<Integer> res){
            if(root == null) return;

            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
            return;
        }
    }

    // using stack, no recursion
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res=new ArrayList<>();
            Stack<TreeNode> stack=new Stack<>();

            if (root==null){
                return res;
            }

            TreeNode node = root;

            while(node!=null || !stack.isEmpty()){
                while (node!=null){
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
            return res;
        }
    }
}
