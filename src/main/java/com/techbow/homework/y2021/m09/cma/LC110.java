public class LC110 {
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
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if(Math.abs(leftHeight - rightHeight) > 1){
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);
        }

        public int getHeight(TreeNode root) {
            if (root == null) return 0;
            int leftHeight = getHeight(root.left);
            // wall
            int rightHeight = getHeight(root.right);
            // do sth
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
}
