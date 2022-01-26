package com.techbow.homework.y2021.m09.cma;

public class LC1026 {
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
        //     DFS理解：深度优先，一支走到黑, 回到分叉点，再走到黑，再回到分叉点。
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val); // initialize both max and min with root.val.
        }
        private int dfs(TreeNode node, int max, int min) {
            if (node == null) { return max - min; } // base case.
            max = Math.max(node.val, max); // update max.
            min = Math.min(node.val, min); // update min.
            // System.out.println(node.val);
            int l = dfs(node.left, max, min); // recurse down.
            int r = dfs(node.right, max, min); // recurse down.

            return Math.max(l, r); // compare all super/sub differences to get result.
        }
    }
}
