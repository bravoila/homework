package com.techbow.homework.y2021.m09.cma;

public class LC669 {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root == null){
                return root;
            }
            if(root.val > high){
                return trimBST(root.left, low, high);
            }
            if(root.val < low){
                return trimBST(root.right, low, high);
            }

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);

            return root;
        }
    }
}
