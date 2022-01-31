package com.techbow.homework.y2021.m09.cma;

public class LC108 {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int start, int end){
            if(start > end) return null;

            int med = start + (end - start)/2;
            TreeNode root = new TreeNode(nums[med]);
            root.left = helper(nums, start, med - 1);
            root.right = helper(nums, med + 1, end);
            return root;

        }
    }
}
