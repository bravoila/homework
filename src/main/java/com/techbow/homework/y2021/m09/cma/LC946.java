package com.techbow.homework.y2021.m09.cma;

public class LC946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int N = pushed.length;
            Stack<Integer> stack = new Stack();

            int j = 0;
            for (int x: pushed) {
                stack.push(x);
                while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return j == N;
        }
    }
}
