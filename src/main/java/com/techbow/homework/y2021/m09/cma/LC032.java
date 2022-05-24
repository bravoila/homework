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

    // two way
    class Solution {
        public int longestValidParentheses(String s) {
            // cc
            if(s == null || s.length() == 0){
                return 0;
            }

            int left = 0;
            int right = 0;
            int res = 0;

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    left++;
                } else{
                    right++;
                }
                if(left == right){
                    res = Math.max(res, 2 * right);
                } else if(right > left){
                    left = 0;
                    right = 0;
                }
            }

            left = 0;
            right = 0;

            for(int i = s.length() - 1; i >= 0; i--){
                if(s.charAt(i) == '('){
                    left++;
                } else{
                    right++;
                }
                if(left == right){
                    res = Math.max(res, 2 * left);
                } else if(left > right){
                    left = 0;
                    right = 0;
                }
            }
            return res;
        }
    }
}
