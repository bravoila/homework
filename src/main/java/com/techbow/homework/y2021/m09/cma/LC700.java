package com.techbow.homework.y2021.m09.cma;

public class LC700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if( root == null || root.val == val){
                return root;
            }

            if(root.val > val){
                return searchBST(root.left, val);
            } else{
                return searchBST(root.right, val);
            }
        }
    }
}
