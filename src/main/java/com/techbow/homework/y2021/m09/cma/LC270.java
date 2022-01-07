package com.techbow.homework.y2021.m09.cma;

public class LC270 {
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
        // find closest
        public int closestValue(TreeNode root, double target) {
            if(root == null) return 0;
            TreeNode cur = root;
//            避免初始化magic number， 最好从初始化为第一个有效的值。
            int res = cur.val;

            while(cur != null){
                if(Math.abs(cur.val - target) < Math.abs(res - target)){
                    res = cur.val;
                }
                if(cur.val < target){
                    cur = cur.right;
                }else if(cur.val > target){
                    cur = cur.left;
                }else{
                    return cur.val;
                }
            }
            return res;
        }
    }
    class Solution {
        // find closest
        public int closestValue(TreeNode root, double target) {
            if(root == null) return root.val;
            TreeNode res = root;
            TreeNode cur = root;

            while(cur != null){
                if(cur.val == target) return cur.val;
                if(Math.abs(cur.val - target) < Math.abs(res.val - target)) res = cur;
                if(cur.val > target) cur = cur.left;
                else cur = cur.right;

            }
            return res.val;
        }
    }

}
