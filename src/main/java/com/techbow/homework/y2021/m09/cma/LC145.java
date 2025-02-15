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

    // no recursion, using stack
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> res = new ArrayList<>();

            if(root == null){
                return res;
            }
            stack.add(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pollLast();
                res.add(0, node.val);
                if(node.left != null){
                    stack.add(node.left);
                }
                if(node.right != null){
                    stack.add(node.right);
                }
            }
            return res;
        }
    }
}

