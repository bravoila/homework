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
//    先办事后recursion O(nlogn)
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


//    先recursion后办事 O(n)
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return getHeight(root) != - 1;
        }

        public int getHeight(TreeNode root) {
            if (root == null) return 0;
            int leftHeight = getHeight(root.left);
            // wall
            int rightHeight = getHeight(root.right);
            // do sth
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
