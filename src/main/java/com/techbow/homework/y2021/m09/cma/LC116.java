package PACKAGE_NAME;public class LC116 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            if(root == null){
                return root;
            }

            Queue<Node> myqueue = new LinkedList<>();
            myqueue.add(root);

            while(!myqueue.isEmpty()){
                int mysize = myqueue.size();

                while(mysize -- > 0){
                    Node node = myqueue.poll();
                    if(mysize == 0){
                        node.next = null;
                    } else{
                        node.next = myqueue.peek();
                    }

                    if(node.left != null){
                        myqueue.add(node.left);
                    }

                    if(node.right != null){
                        myqueue.add(node.right);
                    }

                }
            }
            return root;
        }
    }
}
