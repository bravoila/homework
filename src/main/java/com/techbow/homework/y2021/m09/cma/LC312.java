package com.techbow.homework.y2021.m09.cma;

public class LC312 {
    class Solution {
        public int maxCoins(int[] nums) {
            if(nums == null || nums.length == 0 ){
                return 0;
            }
            int len = nums.length;
            int dp[][] = new int[len][len];

            for(int start = len - 1; start >= 0; start--){
                for(int end = start; end < len; end ++){
                    int max = 0;
                    for(int i = start; i <= end; i++){
                        int val = 0;
                        val += (i == start? 0 : dp[start][i -1]);
                        val += (i == end? 0: dp[i + 1][end]);
                        val += (start == 0? 1 :nums[start - 1])
                                * nums[i]
                                * (end == (len - 1) ? 1 : nums[end + 1]);
                        max = Math.max(max, val);
                    }
                    dp[start][end] = max;
                }
            }
            return dp[0][len - 1];
        }
    }
}
