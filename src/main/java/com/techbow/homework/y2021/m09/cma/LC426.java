package com.techbow.homework.y2021.m09.cma;

public class LC426 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

    class Solution {
        Node prev;
        Node head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return head;
            dfs(root);

            prev.right = head;
            head.left = prev;

            return head;
        }

        public void dfs(Node root){
            if(root == null) return;

            dfs(root.left);

            if(prev != null) {
                prev.right = root;
                root.left = prev;
            }
            else {
                head = root;
            }

            prev = root;

            dfs(root.right);
            // dfs(right);
            // return;
        }
    }
}
