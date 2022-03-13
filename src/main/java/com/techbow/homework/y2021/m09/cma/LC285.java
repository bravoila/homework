package com.techbow.homework.y2021.m09.cma;

public class LC285 {
    // Inorder travelsal
    class Solution {
        // Inorder travelsal
        TreeNode prev;
        TreeNode res;
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            dfs(root, p);
            return res;
        }

        private void dfs(TreeNode root, TreeNode p){
            if(root == null){
                return;
            }
            dfs(root.left, p);

            if(prev != null && res == null){
                res = root;
                return;
            }
            if(root.val == p.val){
                prev = root;
            }

            dfs(root.right, p);
            return;
        }
    }
    // 利用BST性质
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode res = null;

            while(root !=null){
                if(root.val <= p.val){
                    root = root.right;
                } else{
                    res = root;
                    root = root.left;
                }
            }
            return res;
        }
    }
    //
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode res = null;

            while(root !=null){
                if(root.val > p.val){
                    res = root;
                    root = root.left;
                } else{
                    root = root.right;
                }
            }
            return res;
        }
    }
}
