package com.techbow.homework.y2021.m09.cma;

public class LC343 {
//    similar to cut rope
//    dp meaning: maximum product of all parts when you handle i meters cope with one cut
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for(int i = 1; i <= n; i ++){
                int curMax = 0;
                for(int j = 1; j <= i/2; j ++){
                    int curValue = Math.max(j, dp[j]) * Math.max( i - j, dp[i - j]);
                    curMax = Math.max(curValue, curMax);
                }
                dp[i] = curMax;
            }
            int res = 0;
            for(int dpi : dp){
                res = Math.max(res, dpi);
            }
            return res;
        }
    }



}
