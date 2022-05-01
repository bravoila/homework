package com.techbow.homework.y2021.m09.cma;

public class LC232 {
    class MyQueue {
        Stack<Integer> input = new Stack();
        Stack<Integer> output = new Stack();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.isEmpty()? null: output.pop();
        }

        public int peek() {
            if (output.empty())
                while (!input.empty())
                    output.push(input.pop());
            return output.isEmpty()? null: output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }
}
