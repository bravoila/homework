package com.techbow.homework.y2021.m09.cma;

public class LC486 {
    public class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            for (int i = nums.length; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                    } else {
                        int a = nums[i] - dp[i + 1][j];
                        int b = nums[j] - dp[i][j - 1];
                        dp[i][j] = Math.max(a, b);
                    }
                }
            }
            return dp[0][nums.length - 1] >= 0;
        }
    }

    public class Solution {
        //https://www.youtube.com/watch?v=opCEfBH-7ZQ
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];

            // 长度为1
            for(int i = 0; i < n; i ++){
                dp[i][i] = nums[i];
            }
            // 长度为2
            for(int j = 0; j < n - 1; j ++){
                dp[j][j + 1] = Math.max(nums[j], nums[j + 1]);
            }

            int sum = 0;
            for(int i = 0; i < n; i ++){
                sum += nums[i];
            }
            // 长度从3开始
            for (int l = 3; l <= n; l++) {// l是子数组长度
                for (int i = 0; i + l - 1 < nums.length; i++) {// i是起始点
                    int j = i + l - 1; // j是子数组的终点
                    int left = Math.min(dp[i + 1][j - 1], dp[i + 2][j]) + nums[i];
                    int right = Math.min(dp[i][j - 2], dp[i + 1][j - 1]) + nums[j];
                    dp[i][j] = Math.max(left, right);
                }
            }
            return 2*dp[0][n - 1] >= sum;
        }
    }
}
