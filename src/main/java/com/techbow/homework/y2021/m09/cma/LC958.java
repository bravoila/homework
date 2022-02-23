package com.techbow.homework.y2021.m09.cma;

public class LC958 {
    // 什么时候set，什么时候check？
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return false;
            }
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            boolean flag = false;
            while (!que.isEmpty()) {
                TreeNode pollNode = que.poll();

                if (pollNode == null) {
                    flag = true;
                } else {
                    if(flag){
                        return false;
                    }
                    que.offer(pollNode.left);
                    que.offer(pollNode.right);
                }
            }
            return true;
        }
    }


    //s2
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            boolean flag = false;
            while (!que.isEmpty()) {
                TreeNode pollNode = que.poll();

                if (pollNode.left != null) {
                    if(flag){
                        return false;
                    }
                    que.offer(pollNode.left);
                } else{
                    flag = true;
                }
                if (pollNode.right != null) {
                    if(flag){
                        return false;
                    }
                    que.offer(pollNode.right);
                } else{
                    flag = true;
                }
            }
            return true;
        }
    }
}
