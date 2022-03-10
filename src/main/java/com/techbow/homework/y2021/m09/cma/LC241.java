package com.techbow.homework.y2021.m09.cma;

public class LC241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> res = new ArrayList<Integer>();
            boolean isNum = true;
            int n = expression.length();
            for(int i = 0; i < n; i++){
                char c = expression.charAt(i);
                if(c == '+' || c == '-' || c == '*'){
                    isNum = false;
                    List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1, n));

                    List<Integer> one = combine(left, right, c);
                    res.addAll(one);
                }
            }
            if(isNum){
                res.add(Integer.valueOf(expression));
            }
            return res;
        }

        private List<Integer> combine(List<Integer> left, List<Integer> right, char optr){
            List<Integer> res = new ArrayList<Integer>();
            for(int l: left){
                for(int r : right){
                    int result = 0;
                    if(optr == '+') result = l + r;
                    if(optr == '-') result = l - r;
                    if(optr == '*') result = l * r;
                    res.add(result);
                }
            }
            return res;
        }
    }
}
