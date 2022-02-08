package com.techbow.homework.y2021.m09.cma;

public class LC022 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            int l = 0;
            int r = 0;
            dfs(res, new StringBuilder(), n, 0, l, r);
            return res;
        }

        private void dfs(List<String> res, StringBuilder path, int n, int idx, int l, int r){
            if(idx == 2*n && l == r){
                res.add(path.toString());
                return;
            }
            if(idx >= 2*n || l > n || r > n || l < r){
                return;
            }
            // add (
            path.append("(");
            dfs(res, path, n, idx + 1, l + 1, r);
            path.setLength(path.length() - 1);

            // add )
            path.append(")");
            dfs(res, path, n, idx + 1, l , r + 1);
            path.setLength(path.length() - 1);
        }
    }

// 优化版

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            int delta = 0;
            dfs(res, new StringBuilder(), n, delta);
            return res;
        }
        private void dfs(List<String> res, StringBuilder path, int n, int delta){
            if (path.length() == 2*n){
                if(delta == 0){
                    res.add(path.toString());
                }
                return;
            }
            if (delta < 0){
                return;
            }
            int len = path.length();
            path.append("(");
            dfs(res, path, n , delta + 1);
            path.setLength(len);

            path.append(")");
            dfs(res, path, n , delta - 1);
            path.setLength(len);

        }
    }
}
