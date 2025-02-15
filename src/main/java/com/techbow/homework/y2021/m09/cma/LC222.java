package com.techbow.homework.y2021.m09.cma;

public class LC222 {
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
        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            int countLeft = countNodes(root.left);
            int countRight = countNodes(root.right);

            return countLeft + countRight + 1;
        }
    }

//    O(logn) 解法
    class Solution {
        public int countNodes(TreeNode root) {
            if(root == null) return 0;
            int countLeft = getHeight(root.left);
            int countRight = getHeight(root.right);

            int count = 1;
            if(countLeft > countRight){
                count += Math.pow(2, countRight) - 1;
                return count  + countNodes(root.left);
            }else if(countLeft == countRight){
                count += Math.pow(2, countLeft) - 1;
                return count + countNodes(root.right);
            }else{
                return -1;
            }
        }

        private int getHeight(TreeNode root){
            int height = 0;
            while(root != null){
                height++;
                root = root.left;
            }
            return height;
        }
    }

}
