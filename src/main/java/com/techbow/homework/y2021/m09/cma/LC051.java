package com.techbow.homework.y2021.m09.cma;

public class LC051 {
//    用老刘的方法List<int[]>
    class Solution {

        public List<List<String>> solveNQueens(int n) {
            List<int[]> results = new ArrayList<>();
            int[] sol = new int[n];
            Arrays.fill(sol, -1);

            dfs(n, 0, sol , results);

            List<List<String>> outcome = new ArrayList<>();
            for(int[] ys: results) {
                List<String> formed = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for(int y: ys) {
                    for(int dot = 0; dot < y; dot ++) {
                        sb.append(".");
                    }
                    sb.append("Q");
                    for(int dot = y + 1; dot < n; dot++) {
                        sb.append(".");
                    }
                    formed.add(sb.toString());
                    sb.setLength(0);
                }
                outcome.add(formed);
            }
            return outcome;
        }

        public void dfs(int n, int level, int[] sol, List<int[]> res) {
            if(level == n) {
                res.add(Arrays.copyOf(sol, sol.length));
                // results.add(sol.clone());
                return;
            }
//         level增加表示每次call的过程
//         本题中用for loop表示分叉
            for(int j = 0; j < n; j ++) {
                if(isValid(sol, level, j)) {
                    sol[level] = j;
                    dfs(n, level + 1, sol, res);
//                 同层，跨层没问题，backtrack可以不写，一般赋值操作不用写
//              sol[level] = -1;
                }
            }
        }

        public Boolean isValid(int[] sol, int level, int j) {
            for(int idx = 0; idx < level; idx ++) {
                //             sol[]位置上没有值或者不在对角线上
                if(sol[idx] == j || Math.abs(sol[idx] - j) ==  level - idx) return false;
            }
            return true;
        }
    }

// 直接拼List<List<String>>
    class Solution{
        public List<List<String>> solveNQueens(int n){
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> path = new ArrayList<String>();
            dfs(res, path, n, 0);
            return res;
        }

        private void dfs(List<List<String>> res, List<String> path, int n, int level){
            if(path.size() == n) {
                List<String> newPath = new ArrayList<>();
                for(String str : path) {
                    newPath.add(str);
                }
                res.add(newPath);
                return;
            }

            for(int i = 0; i < n; i++){
                char[] chars = new char[n];
                for (int j  = 0; j < n; j++){
                    chars[j] = '.';
                }
                chars[i] = 'Q';
                path.add(new String(chars));

                if(isValid(path, level, i)){
                    dfs(res, path, n, level+1);
                }
                path.remove(path.size() - 1);
            }
        }
        //isValid可以用DP优化
        public boolean isValid(List<String> path, int level, int col){
            if(path == null || path.size() == 1) return true;
            for(int i = 0; i < level; i++){
                if(path.get(i).charAt(col) == 'Q') return false;
            }
            for(int i = 0; i < level; i++){
                int prevQ =path.get(i).indexOf('Q');
                if(Math.abs(prevQ - col) == level - i ) return false;
            }
            return true;
        }
    }

}
