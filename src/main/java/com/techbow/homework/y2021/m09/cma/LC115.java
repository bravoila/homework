package com.techbow.homework.y2021.m09.cma;

public class LC115 {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            if(nums == null || nums.length == 0){
                return false;
            }

            int len = nums.length;
            int sum = 0;
            int dp[][] = new int[len][len];

            for(int i = len - 1; i >= 0; i--){
                sum += nums[i];
                for(int j = i; j < len; j++){
                    if(i == j){
                        dp[i][j] = nums[i];
                        continue;
                    }

                    int a = (i + 2 <= j) ? dp[i + 2][j] : 0;
                    int b = (i + 1 <= j - 1)? dp[i + 1][j - 1] :0;
                    int c = (i <= j - 2) ? dp[i][j - 2] : 0;

                    dp[i][j] = Math.max(nums[i] + Math.min(a,b), nums[j] + Math.min(b,c));
                }
            }
            return dp[0][len - 1] >= sum - dp[0][len - 1];
        }
    }
}
