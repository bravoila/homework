package com.techbow.homework.y2021.m09.cma;

public class LC106 {
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
        int postorderIndex;
        Map<Integer, Integer> inorderIndexMap;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
//         postorder 将值和index存到hasmap里
            postorderIndex = postorder.length - 1;
            // build a hashmap to store value -> its index relations
            inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return arrayToTree(postorder, 0, postorder.length - 1);
        }

        private TreeNode arrayToTree(int[] postorder, int left, int right) {
//         postorder拿root，inorder拿leaf
            // if there are no elements to construct the tree
            if (left > right) return null;

            // select the postorder_index element as the root and increment it
            int rootValue = postorder[postorderIndex--];
            TreeNode root = new TreeNode(rootValue);

            // build right and left subtree
            //  post order left - right - root, 建树的时候 left <- right <- root
            // excluding inorderIndexMap[rootValue] element because it's the root
            root.right = arrayToTree(postorder, inorderIndexMap.get(rootValue) + 1, right);
            root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootValue) - 1);

            return root;
        }
    }
}
