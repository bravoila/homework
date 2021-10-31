public class LC102 {
    class Solution {
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

        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> myqueue  = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<List<Integer>>();
//         C.C
            if(root == null) {
                return res;
            }

            myqueue.add(root);
            while(!myqueue.isEmpty()){
                int size = myqueue.size();
                List<Integer> temp = new ArrayList<>();

                while(size -- > 0){
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
            return res;
        }
    }
}
