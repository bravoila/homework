package com.techbow.homework.y2021.m09.cma;

public class LC144 {
    // recursion
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preOrder(root, res);
            return res;
        }
        private void preOrder(TreeNode root, List<Integer> res){
            if(root == null){
                return;
            }
            res.add(root.val);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
    }
    //non- recursion
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> res = new LinkedList<>();

            if(root == null){
                return res;
            }

            stack.add(root);
            while(!stack.isEmpty()){
                //跟左右 到 stack里就要反着 变成根右左
                TreeNode node = stack.pollLast();
                res.add(node.val);
                if(node.right != null){
                    stack.add(node.right);
                }
                if(node.left != null){
                    stack.add(node.left);
                }
            }
            return res;
        }
    }
}
