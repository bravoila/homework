package com.techbow.homework.y2021.m09.cma;

public class LC257 {
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
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<String> paths = new LinkedList();
            construct_paths(root, "", paths);
            return paths;
        }

        public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
            if (root != null) {
                path += Integer.toString(root.val);
                if ((root.left == null) && (root.right == null))  // if reach a leaf
                    paths.add(path);  // update paths
                else {
                    path += "->";  // extend the current path
                    construct_paths(root.left, path, paths);
                    construct_paths(root.right, path, paths);
                }
            }
        }
    }

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
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<String> paths = new LinkedList();
            construct_paths(root, "", paths);
            return paths;
        }

        public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
            if (root == null) return;

            path += Integer.toString(root.val);
            int len = path.length();
            path += "->";  // extend the current path
            construct_paths(root.left, path, paths);
            construct_paths(root.right, path, paths);
            path = path.substring(0, len);

            if ((root.left == null) && (root.right == null))  // if reach a leaf
                paths.add(path);  // update paths
        }
    }

}
