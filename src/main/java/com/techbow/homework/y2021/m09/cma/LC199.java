package com.techbow.homework.y2021.m09.cma;

public class LC199 {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                int size = queue.size();
//             peek是看第一个元素，所以后面左右是反着来的
                res.add(queue.peek().val);
                for(int i = 0; i < size; i ++){
                    TreeNode curr = queue.poll();
                    if(curr.right != null){
                        queue.add(curr.right);
                    }
                    if(curr.left != null){
                        queue.add(curr.left);
                    }
                }
            }
            return res;
        }
    }
}
