public class LC404 {
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
        public int sumOfLeftLeaves(TreeNode root) {
            Queue<TreeNode> myqueue = new LinkedList<>();
            myqueue.add(root);
            int res = 0;

            while(!myqueue.isEmpty()){
                int mysize = myqueue.size();
                while(mysize -- > 0){
                    TreeNode mynode = myqueue.poll();

                    if(mynode.left != null && mynode.left.left == null && mynode.left.right == null){
                        res += mynode.left.val;
                    }

                    if(mynode.left != null){
                        myqueue.add(mynode.left);
                    }

                    if(mynode.right != null){
                        myqueue.add(mynode.right);
                    }
                }
            }
            return res;
        }
    }
}
