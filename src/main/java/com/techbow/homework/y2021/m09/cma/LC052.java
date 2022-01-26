package com.techbow.homework.y2021.m09.cma;

public class LC052 {
    class Solution {
        public int totalNQueens(int n) {
            List<int[]> results = new ArrayList<>();
            int[] sol = new int[n];
            Arrays.fill(sol, -1);

            return dfs(n, 0, sol , results);
        }

        public int dfs(int n, int level, int[] sol, List<int[]> res) {
            if(level == n) {
                return 1;
            }
//         level增加表示每次call的过程
//         本题中用for loop表示分叉
            int count = 0;
            for(int j = 0; j < n; j ++) {
                if(isValid(sol, level, j)) {
                    sol[level] = j;
                    count += dfs(n, level + 1, sol, res);
//                 同层，跨层没问题，backtrack可以不写，一般赋值操作不用写
//              sol[level] = -1;
                }
            }
            return count;
        }

        public Boolean isValid(int[] sol, int level, int j) {
            for(int idx = 0; idx < level; idx ++) {
                // sol[]位置上没有值或者不在对角线上，如果在对角线或者反对角线上， the difference between the row and column indexes (row - col) will be constant.
                if(sol[idx] == j || Math.abs(sol[idx] - j) ==  level - idx) return false;
            }
            return true;
        }
    }
}
