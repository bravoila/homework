package com.techbow.homework.y2021.m09.cma;

public class LC105 {
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
// 总体思路：用别的order找出root，用inorder再找左右子树
// 如果把null的信息都保留了，那么用一个order就能还原tree
// 否则就要一个inorder加一个别的order，必须有inorder，不能是pre + postporder
    class Solution {
        int preorderIndex;
        Map<Integer, Integer> inorderIndexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
//         preorder 将值和index存到hasmap里
            preorderIndex = 0;
            // build a hashmap to store value -> its index relations
            inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return arrayToTree(preorder, 0, preorder.length - 1);
        }

        private TreeNode arrayToTree(int[] preorder, int left, int right) {
//         preorder拿root，inorder拿leaf
            // if there are no elements to construct the tree
            if (left > right) return null;

            // select the preorder_index element as the root and increment it
            int rootValue = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootValue);

            // build left and right subtree
            // excluding inorderIndexMap[rootValue] element because it's the root
            root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
            root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
            return root;
        }
    }
}
