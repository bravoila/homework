public class LC107 {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            Queue<TreeNode> myqueue = new LinkedList<>();
            myqueue.add(root);
            if(root == null){
                return res;
            }

            while(!myqueue.isEmpty()){
                int mysize = myqueue.size();
                List<Integer> temp = new ArrayList<>();
                while(mysize -- > 0){
                    root = myqueue.poll();
                    temp.add(root.val);
                    if(root.left != null){
                        myqueue.add(root.left);
                    }
                    if(root.right != null){
                        myqueue.add(root.right);
                    }
                }
                res.add(temp);
            }
            Collections.reverse(res);
            return res;
        }
    }
}
