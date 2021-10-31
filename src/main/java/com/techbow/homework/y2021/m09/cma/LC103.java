public class LC103 {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> myqueue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            int mylevel = 0;
            if(root == null){
                return res;
            }

            myqueue.add(root);

            while(!myqueue.isEmpty()){
                int mysize = myqueue.size();
                List<Integer> temp = new ArrayList<>();
                while(mysize -- > 0 ){
                    root = myqueue.poll();
                    temp.add(root.val);
                    if(root.left != null){
                        myqueue.add(root.left);
                    }
                    if(root.right != null){
                        myqueue.add(root.right);
                    }
                }
                if(mylevel %2 == 0){
                    res.add(temp);
                }
                else{
                    Collections.reverse(temp);
                    res.add(temp);
                }
                mylevel ++;
            }
            return res;
        }
    }
}
