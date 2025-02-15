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
// method 2
    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return root;
            }
            //Find a valid root which is used to return.
            while (root != null && (root.val < L || root.val > R)) {
                if (root.val < L) {
                    root = root.right;
                }
                if (root.val > R) {
                    root = root.left;
                }
            }
            TreeNode dummy = root;
            // Remove the invalid nodes from left subtree.
            while (dummy != null) {
                while (dummy.left != null && dummy.left.val < L) {
                    dummy.left = dummy.left.right;
                    // If the left child is smaller than L, then we just keep the right subtree of it.
                }
                dummy = dummy.left;
            }
            dummy = root;
            // Remove the invalid nodes from right subtree
            while (dummy != null) {
                while (dummy.right != null && dummy.right.val > R) {
                    dummy.right = dummy.right.left;
                    // If the right child is biggrt than R, then we just keep the left subtree of it.
                }
                dummy = dummy.right;
            }
            return root;
        }
    }
}
