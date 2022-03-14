package com.techbow.homework.y2021.m09.cma;

public class LC272 {
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
    //拉直的写法
    class Solution {
        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) return;
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> nums = new ArrayList();
            inorder(root, nums);

            Collections.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
                }
            });
            return nums.subList(0, k);
        }
    }
// 用stack
    class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Stack<TreeNode> lst = new Stack<TreeNode>();
            Stack<TreeNode> rst = new Stack<TreeNode>();
            List<Integer> res = new ArrayList<>();

            TreeNode curr = root;
            while(curr != null){
                if(curr.val < target){
                    //go right
                    lst.push(curr);
                    curr = curr.right;
                } else{
                    //go left
                    rst.push(curr);
                    curr = curr.left;
                }
            }
            // k most close
            while(k-- > 0){
                if(!lst.isEmpty() && !rst.isEmpty()){
                    if(Math.abs(lst.peek().val - target) < Math.abs(rst.peek().val - target)){
                        res.add(leftMinus(lst));
                    }else{
                        res.add(rightPlus(rst));
                    }
                } else if(!lst.isEmpty()){
                    res.add(leftMinus(lst));
                } else if(!rst.isEmpty()){
                    res.add(rightPlus(rst));
                } else{
                    break;
                }
            }
            return res;
        }

        private int leftMinus(Stack<TreeNode> st){
            TreeNode top = st.pop();
            TreeNode curr = top.left;
            while(curr != null){
                st.push(curr);
                curr = curr.right;
            }
            return top.val;
        }

        private int rightPlus(Stack<TreeNode> st){
            TreeNode top = st.pop();
            TreeNode curr = top.right;
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            return top.val;
        }
    }
}
