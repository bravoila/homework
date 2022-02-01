package com.techbow.homework.y2021.m09.cma;

public class LC221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int dp[][] = new int[m + 1][n + 1];
            dp[0][0] = 0;
            int maxCount = 0;

            for(int i = 1; i < m + 1; i++){
                for(int j = 1; j < n + 1; j++){
                    if(matrix[i - 1][j - 1] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;            }
                    maxCount = Math.max(maxCount, dp[i][j]);
                }
            }
            return maxCount * maxCount;

        }
    }
}
