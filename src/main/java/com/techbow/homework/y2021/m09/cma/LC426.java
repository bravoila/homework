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

//         成环
            prev.right = head;
            head.left = prev;

            return head;
        }

        public void dfs(Node root){
//         in order traversal
            if(root == null) return;

            dfs(root.left);

            if(prev != null) {
//             构建双向列表， prev向右指， root向左指
                prev.right = root;
                root.left = prev;
            }
            else {
                head = root;
            }
//         prev向下一个移动，
            prev = root;

            dfs(root.right);
            // dfs(right);
            // return;
        }
    }

// 有tail 正规做法

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
        Node head;
        Node prev;
        Node tail;
        public Node treeToDoublyList(Node root) {
            if(root == null) return head;
            dfs(root);

            head.left = tail;
            tail.right = head;

            return head;
        }

        private void dfs(Node root){
//         in order
            if(root == null) return;
            dfs(root.left);

            if(prev == null){
                head = root;
            } else{
//             向左指，向右指
                root.left = prev;
                prev.right = root;
            }

            tail = root;
            prev = root;

            dfs(root.right);
        }
    }
}
