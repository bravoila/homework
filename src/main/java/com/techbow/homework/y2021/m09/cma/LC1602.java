package com.techbow.homework.y2021.m09.cma;

public class LC1602 {
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
        public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
            if(root == null) return null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i ++){
                    TreeNode curNode = queue.poll();
                    if(curNode.val == u.val){
                        if(i == size - 1){
                            return null;
                        }
                        return queue.poll();
                    }

                    if(curNode.left != null){
                        queue.offer(curNode.left);
                    }
                    if(curNode.right != null){
                        queue.offer(curNode.right);
                    }
                }
            }
            return null;
        }
    }
}
