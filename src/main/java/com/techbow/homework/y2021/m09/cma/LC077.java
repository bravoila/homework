package com.techbow.homework.y2021.m09.cma;

public class LC077 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(res, path, 1, k, n);
            return res;

        }
        private void dfs( List<List<Integer>> res, List<Integer> path, int num, int k, int n ){
            if(path.size() == k){
                // 注意添加的数据类型
                res.add(new ArrayList<Integer>(path));
                return;
            }
            int pathLen = path.size();
            for(int i = num; i <= n; i++ ){
                path.add(i);
                dfs(res, path, i + 1, k, n);
                path.remove(pathLen);
            }
        }
    }
}
