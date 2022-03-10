package com.techbow.homework.y2021.m09.cma;

public class LC333 {
    class NodeValue {
        public int max, min, size;

        public NodeValue(int min, int max, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    };

    class Solution {
        private int maxSize = 0;
        public int largestBSTSubtree(TreeNode root) {
            dfs(root);
            return maxSize;
        }

        private NodeValue dfs(TreeNode root){
            if(root == null) return new NodeValue(0,0,0);

            NodeValue left = dfs(root.left);
            NodeValue right = dfs(root.right);

            if(left == null || right == null) return null;

            int size = 1;
            // is BST
            if((left.size == 0 || left.max < root.val) &&
                    (right.size == 0 || right.min > root.val)){
                size = left.size + right.size + 1;
                maxSize = Math.max(maxSize, size);
            } else{
                // not BST
                return null;
            }

            int min = (left.size > 0) ? left.min : root.val;
            int max = (right.size >0) ? right.max: root.val;

            return new NodeValue(min, max, size);
        }
    }
}
