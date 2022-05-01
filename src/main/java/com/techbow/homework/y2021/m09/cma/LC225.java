package com.techbow.homework.y2021.m09.cma;

public class LC225 {
    // two queue
    class MyStack {
        Queue<Integer> queue;

        public MyStack(){
            this.queue=new LinkedList<Integer>();
        }

        // Push element x onto stack.
        public void push(int x) {
            queue.add(x);
            for(int i=0;i<queue.size()-1;i++){
                queue.add(queue.poll());
            }
        }

        // Removes the element on top of the stack.
        public int pop() {
            return queue.poll();
        }

        // Get the top element.
        public int top() {
            return queue.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }



    // one queue
    class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);
            for (int i=1; i<queue.size(); i++)
                queue.add(queue.remove());
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
