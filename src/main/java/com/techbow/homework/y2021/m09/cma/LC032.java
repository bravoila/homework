package com.techbow.homework.y2021.m09.cma;

public class LC032 {
    class Solution {
        public int longestValidParentheses(String s) {
            // cc
            if(s == null || s.length() == 0){
                return 0;
            }

            int res = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push(i);
                } else{
                    stack.pop();
                    if(stack.empty()){
                        stack.push(i);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
            return res;
        }
    }
}
