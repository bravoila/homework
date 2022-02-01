package com.techbow.homework.y2021.m09.cma;

public class LC064 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m + 1][n + 1];

            for(int i = 1; i < m + 1; i++){
                for(int j = 1; j < n + 1; j++){
                    if(i == 1){
                        dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                    } else if (j == 1){
                        dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }


    class Solution {
        int[][] dp;
        public int minPathSum(int[][] grid) {
//         dp用来存之前算过的值
            dp = new int[grid.length][grid[0].length];
            for(int[] d: dp){
                Arrays.fill(d, -1);
            }
            return dfs(grid, 0, 0);
        }
//        DFS
        public int dfs(int[][] grid, int x, int y){
            if(x >= grid.length || y >= grid[0].length){
                return Integer.MAX_VALUE;
            }

            if(x == grid.length - 1 && y == grid[0].length - 1){
                return grid[x][y];
            }

            if(dp[x][y] != -1){
                return dp[x][y];
            }

            int right = dfs(grid, x, y + 1);
            int down = dfs(grid, x + 1, y);

            int max = Math.min(right, down) + grid[x][y];

            dp[x][y] = max;

            return max;
        }
    }
}
