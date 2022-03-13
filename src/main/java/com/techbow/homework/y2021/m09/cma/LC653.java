package com.techbow.homework.y2021.m09.cma;

public class LC653 {
    // 直接拉直，再二分
    public class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List < Integer > list = new ArrayList();
            inorder(root, list);
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int sum = list.get(l) + list.get(r);
                if (sum == k)
                    return true;
                if (sum < k)
                    l++;
                else
                    r--;
            }
            return false;
        }
        public void inorder(TreeNode root, List < Integer > list) {
            if (root == null)
                return;
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    // 不用拉直，用stack
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            // 不拉直解决 时间O(n) 空间lgn
            Stack<TreeNode> lst = initialStackLeft(root);
            Stack<TreeNode> rst = initialStackRight(root);

            while(!lst.isEmpty() && !rst.isEmpty()){
                TreeNode l = lst.peek();
                TreeNode r = rst.peek();

                if(l == r){
                    break;
                }

                int sum = l.val + r.val;
                if(sum < k){
                    leftPlus(lst);
                } else if(sum > k){
                    rightMinus(rst);
                } else{
                    return true;
                }
            }
            return false;
        }
        // 初始左右stack
        private Stack<TreeNode> initialStackLeft(TreeNode root){
            Stack<TreeNode> st = new Stack<>();
            TreeNode curr = root;
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            return st;
        }

        private Stack<TreeNode> initialStackRight(TreeNode root){
            Stack<TreeNode> st = new Stack<>();
            TreeNode curr = root;
            while(curr != null){
                st.push(curr);
                curr = curr.right;
            }
            return st;
        }
        // left++
        private void leftPlus(Stack<TreeNode> st){
            TreeNode top = st.pop();
            TreeNode curr = top.right;
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
        }
        // right--
        private void rightMinus(Stack<TreeNode> st){
            TreeNode top = st.pop();
            TreeNode curr = top.left;
            while(curr != null){
                st.push(curr);
                curr = curr.right;
            }
        }
    }
}
